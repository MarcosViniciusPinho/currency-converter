package com.javalin.currencyconverter.transaction.service;

import com.javalin.currencyconverter.transaction.exception.BadGatewayException;
import com.javalin.currencyconverter.transaction.exception.CurrencyException;
import com.javalin.currencyconverter.transaction.json.Coin;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterService {

    private Logger logger = Logger.getLogger(AdapterService.class.getName());

    public JSONObject send(Coin coin) {
        try {
            //TODO definir como variavel de ambiente a uri('https://api.exchangeratesapi.io/latest?base=')
            String uri = String.format("https://api.exchangeratesapi.io/latest?base=%s", coin.getOrign());
            HttpResponse<JsonNode> response = Unirest.get(uri).asJson();

            if(response.getStatus() >= 400) {
                logger.log(Level.WARNING, (String) response.getBody().getObject().get("error"));
                throw new CurrencyException(String.format("The reported currency does not exist(%s)", coin.getOrign()));
            }

            JSONObject rates = response.getBody().getObject().getJSONObject("rates");
            if(!rates.has(coin.getTarget())) {
                String error = String.format("The reported currency does not exist(%s)", coin.getTarget());
                logger.log(Level.WARNING, error);
                throw new CurrencyException(error);
            }
            return rates;
        } catch (UnirestException e) {
            String error = "There was an error when trying to access the external API";
            logger.log(Level.SEVERE, error);
            throw new BadGatewayException(error, e);
        }
    }

}
