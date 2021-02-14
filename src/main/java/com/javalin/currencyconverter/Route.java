package com.javalin.currencyconverter;

import com.javalin.currencyconverter.transaction.TransactionHandler;
import io.javalin.Javalin;

public class Route {

    public static void register(Javalin app) {
        app.routes(() -> {
            app.post("/", TransactionHandler.create)
                .get("/health-check", ctx -> ctx.json("OK"));//BONUS!
        });
    }

}
