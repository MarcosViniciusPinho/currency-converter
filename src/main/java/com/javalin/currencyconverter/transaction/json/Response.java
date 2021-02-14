package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    //TODO falta entender o que é a transação de conversão utilizada
    private LocalDateTime date;

}
