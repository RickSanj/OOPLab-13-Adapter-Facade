package ua.edu.ucu.apps.demo.task1;

import java.time.LocalDate;

public class MyFacebookUser implements User{
    private FacebookUser facebookUser;

    public MyFacebookUser(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public String getCountry() {
        return facebookUser.getGetUserCountry();
    }

    @Override
    public String getEmail() {
        return facebookUser.getGetEmail();
    }

    @Override
    public LocalDate getLastActivDate() {
        return facebookUser.getGetUserActiveTime().toLocalDate();
    }
    
}
