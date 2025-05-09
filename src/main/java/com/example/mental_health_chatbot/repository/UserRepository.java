package com.example.mental_health_chatbot.repository;

import com.example.mental_health_chatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find a user by username
    User findByUsername(String username);

    // Method to find a user by email
    User findByEmail(String email);
}
