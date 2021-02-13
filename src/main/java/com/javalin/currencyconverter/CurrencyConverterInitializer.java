package com.javalin.currencyconverter;

import io.javalin.Javalin;

public class CurrencyConverterInitializer {

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        app.routes(Route.register(app));
        app.start(7000);
    }

}
