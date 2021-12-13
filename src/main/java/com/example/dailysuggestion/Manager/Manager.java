package com.example.dailysuggestion.Manager;

import com.example.dailysuggestion.Model.*;
import org.springframework.stereotype.Service;

@Service
public class Manager implements ManagerInterface {

    @Override
    public RestResponse getSuggestions(String occupation, String character, String weather) {
        Profile profile = buildProfile(occupation, character);
        Weather weatherInfo = buildWeather(weather);
        String suggestion = buildSuggestion(profile, weatherInfo) + "!";
        return buildResponse(suggestion);
    }

    private RestResponse buildResponse(String suggestion) {
        RestResponse response;

        try {
            response = RestResponse.builder()
                    .response(suggestion)
                    .responseStatus(RestResponse.OK)
                    .build();
        } catch (Exception e) {
            response = RestResponse.builder()
                    .response(suggestion)
                    .responseStatus(RestResponse.NOT_FOUND)
                    .build();
        }

        return response;
    }

    private String buildSuggestion(Profile profile, Weather weatherInfo) {
        return Suggestion.builder()
                .profile(profile)
                .weather(weatherInfo)
                .build()
                .suggest();
    }

    private Weather buildWeather(String weather) {
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
    }

    private Profile buildProfile(String occupation, String character) {
        return Profile.builder()
                .character(Characteristic.valueOf(character.toUpperCase()))
                .occupation(Occupation.valueOf(occupation.toUpperCase()))
                .build();
    }
}