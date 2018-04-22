package edu.fau.oosd.group9.rentacar;

import android.widget.Toast;

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

    public int authenticateUser(String emailAdd, String inpPassword) {
        if(currentUsers.containsKey(emailAdd)) {
            String regPassword = currentUsers.get(emailAdd).getUserPassword();
            if(regPassword.equals(inpPassword))
                return 1;
            else {
                return -1;
            }
        }
        return -2;
    }

    private Map<String, UserProfile> currentUsers = new HashMap<>();
    private static AppModel instance = new AppModel();
}
