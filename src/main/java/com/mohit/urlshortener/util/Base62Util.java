package com.mohit.urlshortener.util;

public class Base62Util {

    private static final String CHARS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long value) {

        StringBuilder sb = new StringBuilder();

        while (value > 0) {
            sb.append(CHARS.charAt((int)(value % 62)));
            value /= 62;
        }

        return sb.reverse().toString();
    }
}