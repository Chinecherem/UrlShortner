package com.interswitch.UrlShortner.model;

import java.util.List;

public class UrlShortnerResponse extends Response{
    private final String status;

    public UrlShortnerResponse(String code, String description, List<Error> errors, String status) {
        super(code, description, errors);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
