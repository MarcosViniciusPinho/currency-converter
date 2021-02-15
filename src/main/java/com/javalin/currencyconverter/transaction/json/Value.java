package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Value {

    @JsonProperty
    private BigDecimal orign;

    @JsonProperty
    private BigDecimal target;

    public Value(BigDecimal orign) {
        this.orign = orign;
    }

}
