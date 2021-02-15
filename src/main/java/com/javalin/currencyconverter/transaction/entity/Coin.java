package com.javalin.currencyconverter.transaction.entity;

import org.bson.Document;

public class Coin {

    private String orign;
    private String target;

    public Coin(com.javalin.currencyconverter.transaction.json.Coin coin) {
        this.orign = coin.getOrign();
        this.target = coin.getTarget();
    }

    public Coin(Document document) {
        this.orign = document.getString("orign");
        this.target = document.getString("target");
    }

    public String getOrign() {
        return orign;
    }

    public String getTarget() {
        return target;
    }
}
