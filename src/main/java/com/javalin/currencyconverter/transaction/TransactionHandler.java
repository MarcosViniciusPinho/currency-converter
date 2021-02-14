package com.javalin.currencyconverter.transaction;

import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.transaction.service.TransactionService;
import io.javalin.http.Handler;

public class TransactionHandler {

    public static Handler create = ctx -> {
        TransactionService service = new TransactionService();
        Request request = service.validate(ctx.bodyValidator(Request.class));

        //TODO consumir api externa
        //TODO Após consumir realizar os calculos
        ctx.json(service.send(request)).status(201);
    };

}