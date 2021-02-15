package com.javalin.currencyconverter.transaction.entity;

import com.javalin.currencyconverter.transaction.json.Request;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Transaction {

    private ObjectId id;
    private String userId;
    private Coin coin;
    private BigDecimal value;
    private BigDecimal rate;
    private LocalDateTime date;

    public Transaction(Request request, JSONObject rates) {
        this.id = new ObjectId();
        this.userId = request.getUserId();
        this.coin = new Coin(request.getCoin());
        this.value = request.getValue().getOrign();
        this.date = LocalDateTime.now(ZoneOffset.UTC);
        this.rate = BigDecimal.valueOf((Double) rates.get(request.getCoin().getTarget()));
    }

    public ObjectId getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Coin getCoin() {
        return coin;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
