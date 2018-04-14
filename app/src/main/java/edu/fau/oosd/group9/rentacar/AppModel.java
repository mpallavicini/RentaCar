package edu.fau.oosd.group9.rentacar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ohm on 04/14/2018.
 */

public class AppModel {

    public static AppModel getInstance() {
        return instance;
    }

    public void addNewUser(String emailAdd, String password) {
        UserProfile newUser = new UserProfile(emailAdd, password);
        currentUsers.put(emailAdd, newUser);
    }

    public boolean authenticateUser(String emailAdd, String password) {
        if(currentUsers.containsKey(emailAdd)) {
            return true;
        }
        else {
            return false;
        }
    }

    private Map<String, UserProfile> currentUsers = new HashMap<>();
    private static AppModel instance = new AppModel();
}
