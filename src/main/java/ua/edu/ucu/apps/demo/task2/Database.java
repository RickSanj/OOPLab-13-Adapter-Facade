package ua.edu.ucu.apps.demo.task2;

import ua.edu.ucu.apps.demo.task2.БазаДаних;

public class Database extends БазаДаних {
    public String getUserData() {
        return отриматиДаніКористувача();
    }

    public String getStaticData() {
        return отриматиСтатистичніДані();
    }
}
