package com.example.dailysuggestion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller of the homepage
 */
@Controller
public class MainController {

    @GetMapping("/home")
    public String main(Model model) {

        return "index"; //view
    }
}
