package com.javalin.currencyconverter.transaction.repository;

import com.javalin.currencyconverter.transaction.entity.Transaction;

public interface TransactionRepository {

    void create(Transaction transaction);

}
