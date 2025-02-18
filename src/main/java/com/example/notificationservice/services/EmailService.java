package com.example.notificationservice.services;

import jakarta.mail.Session;

public interface EmailService {
    void sendEmail(String toEmail, String subject, String body);
}
