package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coin {

    @JsonProperty
    private String orign;

    @JsonProperty
    private String target;

    public Coin() {}

    public Coin(com.javalin.currencyconverter.transaction.entity.Coin coin) {
        this.orign = coin.getOrign();
        this.target = coin.getTarget();
    }

    public Coin(String orign, String target) {
        this.orign = orign;
        this.target = target;
    }

    public String getOrign() {
        return orign;
    }

    public String getTarget() {
        return target;
    }

    @JsonIgnore
    public boolean hasOrign() {
        return StringUtils.isNotBlank(this.orign);
    }

    @JsonIgnore
    public boolean hasTarget() {
        return StringUtils.isNotBlank(this.target);
    }

}
