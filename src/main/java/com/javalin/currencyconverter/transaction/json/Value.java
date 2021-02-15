package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Value {

    @JsonProperty
    private BigDecimal orign;

    @JsonProperty
    private BigDecimal target;

    public Value() {}

    public Value(BigDecimal orign) {
        this.orign = orign;
    }

    public BigDecimal getOrign() {
        return orign;
    }

    public BigDecimal getTarget() {
        return target;
    }

    @JsonIgnore
    public boolean hasOrign() {
        return this.orign != null;
    }

}
