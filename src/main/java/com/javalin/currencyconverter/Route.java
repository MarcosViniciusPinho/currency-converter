package com.javalin.currencyconverter;

import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

public class Route {

    public static EndpointGroup register(Javalin app) {
        return () -> {
            app.get("/", CurrencyHandler.hello);
        };
    }

}
