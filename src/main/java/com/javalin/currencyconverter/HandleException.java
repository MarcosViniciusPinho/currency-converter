package com.javalin.currencyconverter;

import com.javalin.currencyconverter.transaction.exception.BadGatewayException;
import com.javalin.currencyconverter.transaction.exception.CurrencyException;
import com.javalin.currencyconverter.transaction.exception.NotFoundException;
import com.javalin.currencyconverter.transaction.exception.RequiredException;
import io.javalin.Javalin;

public class HandleException {

    public static void register(Javalin app) {
        //TODO se sobrar tempo padronizar a resposta de erro
        app.exception(RequiredException.class, (e, ctx) -> ctx.json(e.getErrors()).status(400));
        app.exception(BadGatewayException.class, (e, ctx) -> ctx.json(e.getMessage()).status(502));
        app.exception(CurrencyException.class, (e, ctx) -> ctx.json(e.getLocalizedMessage()).status(422));
        app.exception(NotFoundException.class, (e, ctx) -> ctx.json(e.getLocalizedMessage()).status(422));
    }

}
