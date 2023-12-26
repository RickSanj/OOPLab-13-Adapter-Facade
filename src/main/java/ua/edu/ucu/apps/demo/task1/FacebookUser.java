package ua.edu.ucu.apps.demo.task1;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FacebookUser {
    private String getEmail;
    private String getUserCountry;
    private LocalDateTime getUserActiveTime;
}
