package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String id;
    private String userId;
    private Coin coin;
    private Value value;
    private BigDecimal rate;
    private LocalDateTime date;

}
