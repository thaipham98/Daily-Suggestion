package com.example.dailysuggestion.Manager;

import com.example.dailysuggestion.Model.*;
import org.springframework.stereotype.Service;

/**
 * Logic handler of the application
 */
@Service
public class Manager implements ManagerInterface {

    /**
     *
     * @param occupation
     * @param character
     * @param weather
     * @return RestResponse that returns to frontend site
     */
    @Override
    public RestResponse getSuggestions(String occupation, String character, String weather) {
        RestResponse response;

        try {
            Profile profile = buildProfile(occupation, character);
            Weather weatherInfo = buildWeather(weather);
            String suggestion = buildSuggestion(profile, weatherInfo) + "!";
            response = RestResponse.builder()
                    .response(suggestion)
                    .responseStatus(RestResponse.OK)
                    .build();
        } catch (Exception e) {
            response = RestResponse.builder()
                    .response(null)
                    .responseStatus(RestResponse.NOT_FOUND)
                    .build();
        }

        return response;
    }

    /**
     *
     * @param profile
     * @param weatherInfo
     * @return suggestion based on user profile and current weather
     */
    private String buildSuggestion(Profile profile, Weather weatherInfo) {
        try {
            return Suggestion.builder()
                    .profile(profile)
                    .weather(weatherInfo)
                    .build()
                    .suggest();

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid argument");
        }
    }

    /**
     *
     * @param weather
     * @return weather detail based on UI data
     */
    private Weather buildWeather(String weather) {

        try {
            String[] weatherInfo = weather.split("\\|");
            String degree = weatherInfo[0].trim().split("°")[0];
            String description = weatherInfo[1].trim();

            if (Weather.isBadWeather(description)) {
                return BadWeather.builder()
                        .degree(Double.parseDouble(degree))
                        .description(description)
                        .build();
            }

            return NiceWeather.builder()
                    .degree(Double.parseDouble(degree))
                    .description(description)
                    .build();

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid argument");
        }

    }

    /**
     *
     * @param occupation
     * @param character
     * @return user profile based on UI data
     */
    private Profile buildProfile(String occupation, String character) {

        try {
            return Profile.builder()
                    .character(Characteristic.valueOf(character.toUpperCase()))
                    .occupation(Occupation.valueOf(occupation.toUpperCase()))
                    .build();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid argument");
        }
    }
}