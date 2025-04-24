package com.example.mental_health_chatbot.service;

import com.example.mental_health_chatbot.model.User;
import com.example.mental_health_chatbot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register a new user
    public User registerUser(String email, String password, String username) {
        String encodedPassword = passwordEncoder.encode(password);
        User newUser = new User(username, email, encodedPassword, null);  // Assuming null for profile picture
        return userRepository.save(newUser);
    }

    // Find a user by their email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find a user by their username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
