package com.javalin.currencyconverter.transaction.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty
    private String userId;

    @JsonProperty
    private List<Result> transactions;

    public Response(String id, List<Result> transactions) {
        this.userId = id;
        this.transactions = transactions;
    }
}
