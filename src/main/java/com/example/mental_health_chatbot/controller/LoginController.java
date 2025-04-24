package com.example.mental_health_chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login"; // Return the login form view
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Make sure you have dashboard.html under templates/
    }

}

