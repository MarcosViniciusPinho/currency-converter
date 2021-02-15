package com.javalin.currencyconverter.transaction.service;

import com.javalin.currencyconverter.transaction.entity.Transaction;
import com.javalin.currencyconverter.transaction.exception.RequiredException;
import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.transaction.json.Response;
import com.javalin.currencyconverter.transaction.json.Result;
import com.javalin.currencyconverter.transaction.repository.TransactionRepository;
import com.javalin.currencyconverter.transaction.repository.impl.TransactionRepositoryImpl;
import io.javalin.core.validation.BodyValidator;
import io.javalin.core.validation.Validator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private TransactionRepository repository;
    private AdapterService service;

    public TransactionService() {
        this.repository = new TransactionRepositoryImpl();
        this.service = new AdapterService();
    }

    public void create(BodyValidator<Request> bodyValidator) {
        Request request = this.validate(bodyValidator);
        this.repository.create(new Transaction(request, this.service.send(request.getCoin())));
    }

    public Response getAll() {
        List<Result> results = new ArrayList<>();
        String userId = StringUtils.EMPTY;
        for (Transaction transaction : this.repository.findAll()) {
            results.add(new Result(transaction));
            userId = transaction.getUserId();
        }
        return new Response(userId, results);
    }

    private Request validate(BodyValidator<Request> bodyValidator) {
        Validator<Request> validator = bodyValidator.check(Request::hasUserId, "Field 'userId' is required")
                .check(Request::hasCoin, "Required of 'coin' fields have not been filled")
                .check(Request::hasValue, "Required of 'value' fields have not been filled");
        if (validator.hasError()) {
            throw new RequiredException(validator.errors());
        }
        return validator.get();
    }

}
