package com.example.dailysuggestion.Model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Represent the current weather detail
 */
@AllArgsConstructor
public abstract class Weather {

    private static final Set<String> BAD_CONDITION = new HashSet<>(List.of("Thunderstorm", "Drizzle", "Rain", "Snow", "Atmosphere"));

    protected Double degree;
    protected String description;

    @Override
    public String toString() {
        return "Weather{" +
                "degree=" + degree +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     *
     * Inform about the current weather
     */
    public abstract String inform();

    /**
     *
     * @param description weather description
     * @return whether the weather is nice or bad
     */
    public static boolean isBadWeather(String description) {
        String detail = description.split(",")[0];
        return BAD_CONDITION.contains(detail);
    }

    /**
     *
     * @return whether the weather is nice or bad
     */
    public abstract boolean isBadWeather();
}
