package com.example.dailysuggestion.Model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public abstract class Weather {

    private static final Set<String> BAD_CONDITION = new HashSet<>(Arrays.asList("Thunderstorm, Drizzle, Rain, Snow, Atmosphere"));

    protected Double degree;
    protected String description;

    @Override
    public String toString() {
        return "Weather{" +
                "degree=" + degree +
                ", description='" + description + '\'' +
                '}';
    }

    public abstract String inform();

    public static boolean isBadWeather(String description) {
        return BAD_CONDITION.contains(description.split(",")[0]);
    }

    public abstract boolean isBadWeather();
}
