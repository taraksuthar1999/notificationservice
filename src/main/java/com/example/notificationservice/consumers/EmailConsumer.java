package com.example.notificationservice.consumers;

import com.example.notificationservice.dtos.SignUpUserMail;
import com.example.notificationservice.services.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    public EmailConsumer(EmailService emailService, ObjectMapper objectMapper) {
        this.emailService = emailService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "user-signup", groupId = "email")
    public void consume(String message) throws JsonProcessingException {
        SignUpUserMail sendEmail = objectMapper.readValue(message, SignUpUserMail.class);
        emailService.sendEmail(sendEmail.getToEmail(), sendEmail.getSubject(), sendEmail.getBody());
    }
}
