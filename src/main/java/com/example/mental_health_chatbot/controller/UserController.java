package com.example.mental_health_chatbot.controller;

import com.example.mental_health_chatbot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Add an empty User object to the model
        return "register"; // Name of your Thymeleaf template (register.html)
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Handle the form submission, for example, saving the user to the database
        return "redirect:/login"; // Redirect to the login page after successful registration
    }
}

