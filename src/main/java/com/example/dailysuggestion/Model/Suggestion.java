package com.example.dailysuggestion.Model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.example.dailysuggestion.Model.Characteristic.EXTROVERT;
import static com.example.dailysuggestion.Model.Characteristic.INTROVERT;
import static com.example.dailysuggestion.Model.Occupation.STUDENT;
import static com.example.dailysuggestion.Model.Occupation.WORKER;

/**
 * Represent suggestion accordingly
 */
@Builder
public class Suggestion {

    private static final List<String> BAD_WEATHER_STUDENT_INDOOR_ACTIVITIES = Arrays.asList("playing video games", "reading a book", "cooking your favorite dish", "watching a movie", "doing some yoga");
    private static final List<String> BAD_WEATHER_WORKER_INDOOR_ACTIVITIES = Arrays.asList("a Broadway show", "going to spa", "a steak dine in", "making wine");
    private static final List<String> NICE_WEATHER_STUDENT_INDOOR_ACTIVITIES = Arrays.asList("go to a museum", "go to the library", "go to a coffee", "go to the gym");
    private static final List<String> NICE_WEATHER_STUDENT_OUTDOOR_ACTIVITIES = Arrays.asList("play your favorite sport", "go around in the park", "run by the river", "go picnic with your family", "go hiking with your friends");
    private static final List<String> NICE_WEATHER_WORKER_INDOOR_ACTIVITIES = Arrays.asList("go to a restaurant", "go to an art gallery", "go to the museum", "go to a shopping mall");
    private static final List<String> NICE_WEATHER_WORKER_OUTDOOR_ACTIVITIES = Arrays.asList("go to a sky diving", "go for a tinder date", "go shopping", "play golf");


    private Profile profile;
    private Weather weather;

    /**
     *
     * @return Suggestion based on user's profile and current weather
     */
    public String suggest() {
        Random randomizer = new Random();
        if (weather.isBadWeather()) {
            if (profile.getOccupation() == STUDENT && profile.getCharacter() == INTROVERT) {
                return weather.inform() + BAD_WEATHER_STUDENT_INDOOR_ACTIVITIES.get(randomizer.nextInt(BAD_WEATHER_STUDENT_INDOOR_ACTIVITIES.size()));
            }
            else if (profile.getOccupation() == STUDENT && profile.getCharacter() == EXTROVERT) {
                return weather.inform() + BAD_WEATHER_STUDENT_INDOOR_ACTIVITIES.get(randomizer.nextInt(BAD_WEATHER_STUDENT_INDOOR_ACTIVITIES.size()));
            }
            else if (profile.getOccupation() == WORKER && profile.getCharacter() == INTROVERT) {
                return weather.inform() + BAD_WEATHER_WORKER_INDOOR_ACTIVITIES.get(randomizer.nextInt(BAD_WEATHER_WORKER_INDOOR_ACTIVITIES.size()));
            }
            else if (profile.getOccupation() == WORKER && profile.getCharacter() == EXTROVERT) {
                return weather.inform() + BAD_WEATHER_WORKER_INDOOR_ACTIVITIES.get(randomizer.nextInt(BAD_WEATHER_WORKER_INDOOR_ACTIVITIES.size()));
            }
        }

        else {
            if (profile.getOccupation() == STUDENT && profile.getCharacter() == INTROVERT) {
                return weather.inform() + NICE_WEATHER_STUDENT_INDOOR_ACTIVITIES.get(randomizer.nextInt(NICE_WEATHER_STUDENT_INDOOR_ACTIVITIES.size()));
            }
            else if (profile.getOccupation() == STUDENT && profile.getCharacter() == EXTROVERT) {
                return weather.inform() + NICE_WEATHER_STUDENT_OUTDOOR_ACTIVITIES.get(randomizer.nextInt(NICE_WEATHER_STUDENT_OUTDOOR_ACTIVITIES.size()));
            }
            else if (profile.getOccupation() == WORKER && profile.getCharacter() == INTROVERT) {
                return weather.inform() + NICE_WEATHER_WORKER_INDOOR_ACTIVITIES.get(randomizer.nextInt(NICE_WEATHER_WORKER_INDOOR_ACTIVITIES.size()));
            }
            else if (profile.getOccupation() == WORKER && profile.getCharacter() == EXTROVERT) {
                return weather.inform() + NICE_WEATHER_WORKER_OUTDOOR_ACTIVITIES.get(randomizer.nextInt(NICE_WEATHER_WORKER_OUTDOOR_ACTIVITIES.size()));
            }
        }

        return null;
    }
}
