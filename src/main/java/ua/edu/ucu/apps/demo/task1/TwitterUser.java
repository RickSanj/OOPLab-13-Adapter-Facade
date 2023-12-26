package ua.edu.ucu.apps.demo.task1;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TwitterUser {
    private String getUserMail;
    private String getCountry;
    private LocalDateTime getLastActiveTime;
}
