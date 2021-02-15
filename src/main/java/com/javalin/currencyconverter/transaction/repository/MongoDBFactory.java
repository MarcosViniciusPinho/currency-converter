package com.javalin.currencyconverter.transaction.repository;

import com.javalin.currencyconverter.config.PropertyConfig;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class MongoDBFactory {

    public MongoCollection<Document> openConnection() {
        MongoClient mongo = new MongoClient(PropertyConfig.getValue("mongodb.host"), PropertyConfig.getValueAsInt("mongodb.port"));
        MongoDatabase db = mongo.getDatabase(PropertyConfig.getValue("mongodb.database.name"));
        return db.getCollection(PropertyConfig.getValue("mongodb.database.collection"));
    }

}
