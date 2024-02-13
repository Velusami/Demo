package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhatsAppNotificationRequest {
    private String to;
    private String message;
}
