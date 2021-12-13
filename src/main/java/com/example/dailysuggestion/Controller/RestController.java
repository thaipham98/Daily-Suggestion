package com.example.dailysuggestion.Controller;

import com.example.dailysuggestion.Manager.Manager;
import com.example.dailysuggestion.Model.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {

    private Manager manager;

    @GetMapping("/suggest")
    public RestResponse suggestThingToDo(@RequestParam("occupation") String occupation,
                                         @RequestParam("character") String character,
                                         @RequestParam("weather") String weather) {

        return manager.getSuggestions(occupation, character, weather);
    }
}
