package ua.edu.ucu.apps.demo.task1;

import java.time.LocalDate;

public interface User {
    public String getEmail();

    public String getCountry();
    
    public LocalDate getLastActivDate();
}
