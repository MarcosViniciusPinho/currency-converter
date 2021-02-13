package com.javalin.currencyconverter;

import io.javalin.http.Handler;

public class CurrencyHandler {

    public static Handler hello = ctx -> {
        ctx.json("Hello World");
    };

}
