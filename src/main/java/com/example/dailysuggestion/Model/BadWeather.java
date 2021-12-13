package com.example.dailysuggestion.Model;

import lombok.Builder;

public class BadWeather extends Weather {

    @Builder
    public BadWeather(Double degree, String description) {
        super(degree, description);
    }

    @Override
    public String inform() {
        return "The weather is not nice today, how about ";
    }

    @Override
    public boolean isBadWeather() {
        return true;
    }
}
