package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Value {

    @JsonProperty
    private BigDecimal orign;

    @JsonProperty
    private BigDecimal target;

    public Value(BigDecimal orign, BigDecimal rate) {
        this.orign = orign;
        this.target = this.calculateTarget(rate);
    }

    @JsonIgnore
    private BigDecimal calculateTarget(BigDecimal rate) {
        return this.orign.multiply(rate).setScale(2, BigDecimal.ROUND_FLOOR);
    }
}
