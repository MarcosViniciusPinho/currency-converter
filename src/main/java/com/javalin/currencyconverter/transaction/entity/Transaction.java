package com.javalin.currencyconverter.transaction.entity;

import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.util.LocalDateTimeUtil;
import org.bson.Document;
import org.bson.types.Decimal128;
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
        this.value = request.getValue();
        this.date = LocalDateTime.now(ZoneOffset.UTC);
        this.rate = BigDecimal.valueOf((Double) rates.get(request.getCoin().getTarget()));
    }

    public Transaction(Document document) {
        this.id = document.getObjectId("_id");
        this.userId = document.getString("userId");
        this.coin = new Coin((Document)document.get("coin"));
        this.value = ((Decimal128) document.get("value")).bigDecimalValue();
        this.date = LocalDateTimeUtil.toDate(document.getString("date"));
        this.rate = ((Decimal128) document.get("rate")).bigDecimalValue();
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

    public String getDateAsString() {
        return LocalDateTimeUtil.toString(this.date);
    }

    public String getIdAsString() {
        return this.id.toHexString();
    }
}
