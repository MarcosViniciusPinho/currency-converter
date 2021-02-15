package com.javalin.currencyconverter.transaction.repository.impl;

import com.javalin.currencyconverter.transaction.entity.Transaction;
import com.javalin.currencyconverter.transaction.repository.MongoDBCollection;
import com.javalin.currencyconverter.transaction.repository.TransactionRepository;
import org.bson.Document;

public class TransactionRepositoryImpl implements TransactionRepository {

    private MongoDBCollection collection;

    public TransactionRepositoryImpl() {
        this.collection = new MongoDBCollection();
    }

    @Override
    public void create(Transaction transaction) {
        //TODO caso sobre tempo trocar este mapeamento por anotações ou algo do gênero, para o código ficar mais legível
        Document coinDocument = new Document("orign", transaction.getCoin().getOrign()).append("target", transaction.getCoin().getTarget());
        this.collection.save(new Document("_id", transaction.getId()).append("userId", transaction.getUserId())
            .append("coin", coinDocument).append("value", transaction.getValue()).append("rate", transaction.getRate())
            .append("date", transaction.getDate().toString().concat("Z")));
    }

}
