package com.example.mental_health_chatbot.controller;

import com.example.mental_health_chatbot.model.User;
import com.example.mental_health_chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Login Page
    @GetMapping("/login")
    public String login() {
        return "login"; // The login page
    }

    // Handling Login Request
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email);

        // Check if user exists and if passwords match
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/chat"; // Redirect to chat page after successful login
        } else {
            return "redirect:/login?error=true"; // Redirect to login page with error
        }
    }

    // Registration Page
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // The registration page
    }

    // Handling Registration Request
    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, @RequestParam String username) {
        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(password);

        // Call userService to save the new user
        userService.registerUser(email, hashedPassword, username);

        return "redirect:/login"; // Redirect to login page after successful registration
    }
}
