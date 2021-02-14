package com.javalin.currencyconverter.json;

import com.javalin.currencyconverter.transaction.json.Coin;
import com.javalin.currencyconverter.transaction.json.Request;
import com.javalin.currencyconverter.transaction.json.Value;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RequestTest {

    @Test
    public void test_must_return_true_when_mandatory_information_is_filled() {
        Request request = new Request("tf6gduygds", new Coin("BRL", "EUR"), new Value(BigDecimal.valueOf(1230.50)));
        Assert.assertTrue(request.hasUserId());
        Assert.assertTrue(request.hasCoin());
        Assert.assertTrue(request.hasValue());
    }

    @Test
    public void test_must_return_false_when_mandatory_information_is_not_filled() {
        Request request = new Request(null, new Coin(), new Value());
        Assert.assertFalse(request.hasUserId());
        Assert.assertFalse(request.hasCoin());
        Assert.assertFalse(request.hasValue());

        request = new Request(null, new Coin(null, "EUR"), null);
        Assert.assertFalse(request.hasCoin());

        request = new Request(null, new Coin("BRL", null), null);
        Assert.assertFalse(request.hasCoin());

        request = new Request();
        Assert.assertFalse(request.hasUserId());
        Assert.assertFalse(request.hasCoin());
        Assert.assertFalse(request.hasValue());
    }

}
