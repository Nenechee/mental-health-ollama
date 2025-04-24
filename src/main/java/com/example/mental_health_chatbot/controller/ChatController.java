package com.example.mental_health_chatbot.controller;

import com.example.mental_health_chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    // Render the chat page (UI)
    @GetMapping("/chat")
    public String showChatPage() {
        return "chat";
    }

    // Handle API call from frontend (JSON)
    @PostMapping("/api/chat")
    @ResponseBody
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody Map<String, String> payload) {
        String message = payload.get("message");

        if (message == null || message.trim().isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("response", "Message cannot be empty.");
            return ResponseEntity.badRequest().body(error);
        }

        String response = chatService.getResponseFromModel(message);
        Map<String, String> result = new HashMap<>();
        result.put("response", response);
        return ResponseEntity.ok(result);
    }
}
