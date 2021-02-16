package com.javalin.currencyconverter.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static String toString(LocalDateTime date) {
        return date != null ? DateTimeFormatter.ofPattern(PATTERN).format(date) : null;
    }

    public static LocalDateTime toDate(String date) {
        return StringUtils.isNotBlank(date) ? LocalDateTime.parse(date, DateTimeFormatter.ofPattern(PATTERN)) : null;
    }

}
