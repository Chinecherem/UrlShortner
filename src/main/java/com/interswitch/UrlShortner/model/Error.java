package com.interswitch.UrlShortner.model;

public class Error {
    private final  String message;
    private final String field;

    public Error(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
