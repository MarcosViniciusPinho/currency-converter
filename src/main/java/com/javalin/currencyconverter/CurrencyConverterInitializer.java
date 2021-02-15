package com.javalin.currencyconverter;

import com.javalin.currencyconverter.config.PropertyConfig;
import io.javalin.Javalin;

public class CurrencyConverterInitializer {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.defaultContentType = "application/json";
            config.contextPath = PropertyConfig.getValue("app.context-path");
            config.enableCorsForAllOrigins();
        });
        Route.register(app);
        HandleException.register(app);
        app.start(7000);
    }

}
