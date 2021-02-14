package com.javalin.currencyconverter;

import io.javalin.Javalin;

public class CurrencyConverterInitializer {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.defaultContentType = "application/json";
            config.contextPath = "/api";
            config.enableCorsForAllOrigins();
        });
        Route.register(app);
        HandleException.register(app);
        app.start(7000);
    }

}
