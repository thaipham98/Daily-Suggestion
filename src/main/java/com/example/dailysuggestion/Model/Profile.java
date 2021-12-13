package com.example.dailysuggestion.Model;

import lombok.Builder;

@Builder
public class Profile {

    private Occupation occupation;
    private Characteristic character;

    public Occupation getOccupation() {
        return occupation;
    }

    public Characteristic getCharacter() {
        return character;
    }
}
