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
            //TODO colocar o host em arquivo properties
            HttpResponse<JsonNode> response = Unirest.get("https://api.exchangeratesapi.io/latest?base=USD").asJson();
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
