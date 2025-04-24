package com.example.mental_health_chatbot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    private final String LLAMA3_API_URL = "http://localhost:11434/api/chat";  // Update URL if needed

    public String getResponseFromModel(String message) {
        RestTemplate restTemplate = new RestTemplate();

        // Create request body (ensure it's a valid JSON format)
        String requestJson = "{\"model\": \"llama3\", \"message\": {\"role\": \"user\", \"content\": \"" + message + "\"}}";

        // Send the POST request and capture the response
        String response = restTemplate.postForObject(LLAMA3_API_URL, requestJson, String.class);

        // Log the response
        System.out.println("Received response: " + response);

        return response;
    }
}
