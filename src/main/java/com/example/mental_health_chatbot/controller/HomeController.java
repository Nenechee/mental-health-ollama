package com.example.mental_health_chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // This will map to the /src/main/resources/templates/index.html file
    }
}
