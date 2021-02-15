package com.javalin.currencyconverter.transaction.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class MongoDBFactory {

    public MongoCollection<Document> openConnection() {
        //TODO isolar estas configurações em um arquivo de properties
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("currency");
        return db.getCollection("transaction");
    }

}
