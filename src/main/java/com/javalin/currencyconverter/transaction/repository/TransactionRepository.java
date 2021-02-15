package com.javalin.currencyconverter.transaction.repository;

import com.javalin.currencyconverter.transaction.entity.Transaction;

import java.util.List;

public interface TransactionRepository {

    void create(Transaction transaction);
    List<Transaction> findByUserId(String userId);

}
