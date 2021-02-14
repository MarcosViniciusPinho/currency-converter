package com.javalin.currencyconverter.transaction.service;

import com.javalin.currencyconverter.transaction.exception.RequiredException;
import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.transaction.json.Response;
import io.javalin.core.validation.BodyValidator;
import io.javalin.core.validation.Validator;

public class TransactionService {

    public Response send(Request request) {
        return new Response();
    }

    public Request validate(BodyValidator<Request> bodyValidator) {
        Validator<Request> validator = bodyValidator.check(Request::hasUserId, "Field 'userId' is required")
                .check(Request::hasCoin, "Required of 'coin' fields have not been filled")
                .check(Request::hasValue, "Required of 'value' fields have not been filled");
        if (validator.hasError()) {
            throw new RequiredException(validator.errors());
        }
        return validator.get();
    }

}
