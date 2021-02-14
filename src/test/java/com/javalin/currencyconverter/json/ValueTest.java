package com.javalin.currencyconverter.json;

import com.javalin.currencyconverter.transaction.json.Value;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ValueTest {

    @Test
    public void test_must_return_true_when_the_orign_field_is_filled() {
        Value value = new Value(BigDecimal.valueOf(112.25));
        Assert.assertTrue(value.hasOrign());
    }

    @Test
    public void test_must_return_false_when_the_orign_field_is_not_filled() {
        Value value = new Value();
        Assert.assertFalse(value.hasOrign());
    }

}
