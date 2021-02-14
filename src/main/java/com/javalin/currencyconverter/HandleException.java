package com.javalin.currencyconverter;

import com.javalin.currencyconverter.transaction.exception.RequiredException;
import io.javalin.Javalin;

public class HandleException {

    public static void register(Javalin app) {
        app.exception(RequiredException.class, (e, ctx) -> ctx.json(e.getErrors()).status(400));
    }

}
