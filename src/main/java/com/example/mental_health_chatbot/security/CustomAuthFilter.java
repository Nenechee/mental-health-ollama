package com.example.mental_health_chatbot.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthFilter(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String usernameOrEmail = request.getParameter("usernameOrEmail");
        String password = request.getParameter("password");

        // Use usernameOrEmail as the principal
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(usernameOrEmail, password);
        return getAuthenticationManager().authenticate(authRequest);
    }
}
