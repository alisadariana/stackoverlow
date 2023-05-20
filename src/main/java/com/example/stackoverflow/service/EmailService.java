package com.example.stackoverflow.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    String sendSimpleMail(String recipient, String subject, String message);
}
