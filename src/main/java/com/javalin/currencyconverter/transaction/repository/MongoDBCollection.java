package com.javalin.currencyconverter.transaction.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBCollection extends MongoDBFactory {

    private MongoCollection<Document> collection;

    public MongoDBCollection() {
        this.collection = openConnection();
    }

    public void save(Document document) {
        this.collection.insertOne(document);
    }
}
