package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javalin.currencyconverter.transaction.entity.Transaction;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    @JsonProperty
    private String id;

    @JsonProperty
    private Coin coin;

    @JsonProperty
    private Value value;

    @JsonProperty
    private BigDecimal rate;

    @JsonProperty
    private String date;

    public Result(Transaction transaction) {
        this.id = transaction.getIdAsString();
        this.coin = new Coin(transaction.getCoin());
        this.value = new Value(transaction.getValue());
        this.rate = transaction.getRate();
        this.date = transaction.getDateAsString();
    }
}
