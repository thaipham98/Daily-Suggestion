package com.example.dailysuggestion.Model;

import lombok.Builder;

/**
 * Represent profile of an user
 */
@Builder
public class Profile {

    private Occupation occupation;
    private Characteristic character;

    @Override
    public String toString() {
        return "Profile{" +
                "occupation=" + occupation +
                ", character=" + character +
                '}';
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public Characteristic getCharacter() {
        return character;
    }
}
