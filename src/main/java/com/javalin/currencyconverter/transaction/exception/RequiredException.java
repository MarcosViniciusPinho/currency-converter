package com.javalin.currencyconverter.transaction.exception;

import java.util.List;
import java.util.Map;

public class RequiredException extends RuntimeException {

    private Map<String, List<String>> errors;

    public RequiredException(Map<String, List<String>> errors) {
        super("The mandatory informations has not been met");
        this.errors = errors;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }
}
