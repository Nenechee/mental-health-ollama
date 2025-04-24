package com.example.mental_health_chatbot.service;

import com.example.mental_health_chatbot.model.User; // Assuming you have a User model
import com.example.mental_health_chatbot.repository.UserRepository; // Assuming you have a UserRepository
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Try to find the user by username
        User user = userRepository.findByUsername(usernameOrEmail);

        // If the user wasn't found by username, try finding by email
        if (user == null) {
            user = userRepository.findByEmail(usernameOrEmail);
        }

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
