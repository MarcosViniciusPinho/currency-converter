package com.javalin.currencyconverter.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Coin {

    private String orign;
    private String target;

    public Coin(com.javalin.currencyconverter.transaction.json.Coin coin) {
        this.orign = coin.getOrign();
        this.target = coin.getTarget();
    }

    public String getOrign() {
        return orign;
    }

    public String getTarget() {
        return target;
    }
}
