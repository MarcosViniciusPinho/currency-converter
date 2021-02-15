package com.javalin.currencyconverter.config;

import com.javalin.currencyconverter.transaction.exception.InternalServerError;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyConfig {

    private static Logger logger = Logger.getLogger(PropertyConfig.class.getName());

    private static Properties get() {
        try {
            Properties properties = new Properties();
            InputStream file = PropertyConfig.class.getResourceAsStream("/application.properties");
            properties.load(file);
            return properties;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "There was an error when trying to read the properties file", e);
            throw new InternalServerError(e);
        }
    }

    public static String getValue(String key) {
        return get().getProperty(key);
    }

    public static Integer getValueAsInt(String key) {
        return Integer.parseInt(getValue(key));
    }

}
