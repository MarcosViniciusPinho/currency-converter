package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    @JsonProperty
    private String userId;

    @JsonProperty
    private Coin coin;

    @JsonProperty
    private Value value;

    public Request() {}

    public Request(String userId, Coin coin, Value value) {
        this.userId = userId;
        this.coin = coin;
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public Coin getCoin() {
        return coin;
    }

    public Value getValue() {
        return value;
    }

    @JsonIgnore
    public boolean hasUserId() {
        return StringUtils.isNotBlank(this.userId);
    }

    @JsonIgnore
    public boolean hasCoin() {
        return this.coin != null && (this.coin.hasOrign() && this.coin.hasTarget());
    }

    @JsonIgnore
    public boolean hasValue() {
        return this.value != null && this.value.hasOrign();
    }

}
