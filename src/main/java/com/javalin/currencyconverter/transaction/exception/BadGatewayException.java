package com.javalin.currencyconverter.transaction.exception;

public class BadGatewayException extends RuntimeException {

    public BadGatewayException(String message, Throwable cause) {
        super(message, cause);
    }

}
