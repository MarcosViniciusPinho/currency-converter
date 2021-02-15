package com.javalin.currencyconverter.transaction.service;

import com.javalin.currencyconverter.transaction.entity.Transaction;
import com.javalin.currencyconverter.transaction.exception.NotFoundException;
import com.javalin.currencyconverter.transaction.exception.RequiredException;
import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.transaction.json.Response;
import com.javalin.currencyconverter.transaction.json.Result;
import com.javalin.currencyconverter.transaction.repository.TransactionRepository;
import com.javalin.currencyconverter.transaction.repository.impl.TransactionRepositoryImpl;
import io.javalin.core.validation.BodyValidator;
import io.javalin.core.validation.Validator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionService {

    private Logger logger = Logger.getLogger(TransactionService.class.getName());

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

    public Response find(String userId) {
        List<Transaction> transactions = this.repository.findByUserId(userId);
        if(CollectionUtils.isEmpty(transactions)) {
            String error = "No record was found with the information provided";
            logger.log(Level.WARNING, error.concat(String.format("(%s)", userId)));
            throw new NotFoundException(error);
        }
        List<Result> results = new ArrayList<>();
        for (Transaction transaction : transactions) {
            results.add(new Result(transaction));
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
