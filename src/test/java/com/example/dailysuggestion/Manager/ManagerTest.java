package com.example.dailysuggestion.Manager;

import com.example.dailysuggestion.Model.RestResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Autowired
    private Manager manager;

    @BeforeEach
    void init() {
        manager = new Manager();
    }

    @Test
    void givenValidParameters_whenGetSuggestion_returnCorrectResult() {
        String occupation = "worker";
        String character = "introvert";
        String weather = "47.9°F | Clouds, few clouds";

        RestResponse response = manager.getSuggestions(occupation, character, weather);

        assertEquals(RestResponse.OK, response.getResponseStatus());
    }

    @Test
    void givenInValidCharacter_whenGetSuggestions_throwException() {
        String occupation = "worker";
        String character = "superman";
        String weather = "47.9°F | Clouds, few clouds";

        RestResponse response;
        try {
            response = manager.getSuggestions(occupation, character, weather);
        } catch (Exception exception) {
            assertThat(exception)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Invalid argument");
        }
    }

    @Test
    void givenInValidOccupation_whenGetSuggestions_throwException() {
        String occupation = "teacher";
        String character = "introvert";
        String weather = "47.9°F | Clouds, few clouds";


        RestResponse response;
        try {
            response = manager.getSuggestions(occupation, character, weather);
        } catch (Exception exception) {
            assertThat(exception)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Invalid argument");
        }
    }

    @Test
    void givenInValidWeather_whenGetSuggestions_throwException() {
        String occupation = "teacher";
        String character = "introvert";
        String weather = "Cloudy";

        RestResponse response;
        try {
            response = manager.getSuggestions(occupation, character, weather);
        } catch (Exception exception) {
            assertThat(exception)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Invalid argument");
        }
    }

    @Test
    void givenNotValidResponse_whenGetSuggestions_returnCorrectResult() {
        String occupation = "teacher";
        String character = "introvert";
        String weather = "Cloudy";

        RestResponse response = manager.getSuggestions(occupation, character, weather);

        assertEquals(RestResponse.NOT_FOUND, response.getResponseStatus());
    }
}