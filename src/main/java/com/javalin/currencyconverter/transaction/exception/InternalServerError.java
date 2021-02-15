package com.javalin.currencyconverter.transaction.exception;

public class InternalServerError extends RuntimeException{

    public InternalServerError(Throwable cause) {
        super("There was an internal error on the server, please contact your system administrator", cause);
    }

}
