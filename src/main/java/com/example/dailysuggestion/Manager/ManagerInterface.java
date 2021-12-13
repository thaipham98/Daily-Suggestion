package com.example.dailysuggestion.Manager;

import com.example.dailysuggestion.Model.RestResponse;

public interface ManagerInterface {

    RestResponse getSuggestions(String occupation, String character, String weather);
}
