package com.example.mental_health_chatbot.repository;

import com.example.mental_health_chatbot.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUserId(Long userId);
}
