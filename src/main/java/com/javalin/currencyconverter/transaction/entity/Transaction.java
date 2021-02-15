package com.javalin.currencyconverter.transaction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javalin.currencyconverter.transaction.json.Request;
import org.bson.Document;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private ObjectId id;
    private String userId;
    private Coin coin;
    private BigDecimal value;
    private BigDecimal rate;
    private LocalDateTime date;

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

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
        this.date = LocalDateTime.parse(document.getString("date"), DateTimeFormatter.ofPattern(PATTERN));
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

    @JsonIgnore
    public LocalDateTime getDate() {
        return date;
    }

    @JsonProperty(value = "date")
    public String getDateAsString() {
        return DateTimeFormatter.ofPattern(PATTERN).format(this.date);
    }

    @JsonProperty(value = "id")
    public String getIdAsString() {
        return this.id.toHexString();
    }
}
