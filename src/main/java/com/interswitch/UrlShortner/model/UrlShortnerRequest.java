package com.interswitch.UrlShortner.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UrlShortnerRequest {

    @NotBlank(message = "Required")
    @Length(min = 7, max = 2083)
    private String longUrl;

    public UrlShortnerRequest(@NotBlank(message = "Required") @Length(min = 7, max = 2083) String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
