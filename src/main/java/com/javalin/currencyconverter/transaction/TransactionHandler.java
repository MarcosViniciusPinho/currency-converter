package com.javalin.currencyconverter.transaction;

import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.transaction.service.TransactionService;
import io.javalin.http.Handler;

public class TransactionHandler {

    public static Handler create = ctx -> {
        TransactionService service = new TransactionService();
        service.create(ctx.bodyValidator(Request.class));
        ctx.status(201);
    };

    public static Handler find = ctx -> {
        TransactionService service = new TransactionService();
        ctx.json(service.find(ctx.queryParam("userId"))).status(200);
    };

}