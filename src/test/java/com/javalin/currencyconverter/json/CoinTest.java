package com.javalin.currencyconverter.json;

import com.javalin.currencyconverter.transaction.json.Coin;
import org.junit.Assert;
import org.junit.Test;

public class CoinTest {

    @Test
    public void test_must_return_true_when_mandatory_information_is_filled() {
        Coin coin = new Coin("BRL", "EUR");
        Assert.assertTrue(coin.hasOrign());
        Assert.assertTrue(coin.hasTarget());
    }

    @Test
    public void test_must_return_false_when_mandatory_information_is_not_filled() {
        Coin coin = new Coin();
        Assert.assertFalse(coin.hasOrign());
        Assert.assertFalse(coin.hasTarget());
    }

}
