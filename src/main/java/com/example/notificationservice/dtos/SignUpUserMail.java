package com.example.notificationservice.dtos;

import lombok.Data;

@Data
public class SignUpUserMail {
    private String toEmail;
    private String subject;
    private String body;
}
