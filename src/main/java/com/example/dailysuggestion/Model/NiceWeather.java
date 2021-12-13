package com.example.dailysuggestion.Model;

import lombok.Builder;

/**
 * Represent nice weather
 */
public class NiceWeather extends Weather{

    @Builder
    public NiceWeather(Double degree, String description) {
        super(degree, description);
    }

    @Override
    public String inform() {
        return "Hey, it's awesome outside, let ";
    }

    @Override
    public boolean isBadWeather() {
        return false;
    }
}
