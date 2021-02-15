package com.javalin.currencyconverter.transaction.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDBCollection extends MongoDBFactory {

    private MongoCollection<Document> collection;

    public MongoDBCollection() {
        this.collection = openConnection();
    }

    public void save(Document document) {
        this.collection.insertOne(document);
    }

    public FindIterable<Document> findByUserId(String userId) {
        return this.collection.find(Filters.eq("userId", userId));
    }
}
