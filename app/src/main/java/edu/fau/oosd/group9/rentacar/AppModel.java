package edu.fau.oosd.group9.rentacar;

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
        registeredUsers.put(emailAdd, newUser);
        currentUser = emailAdd;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public int authenticateUser(String emailAdd, String inpPassword) {
        if(registeredUsers.containsKey(emailAdd)) {
            String regPassword = registeredUsers.get(emailAdd).getUserPassword();
            if(regPassword.equals(inpPassword)) {
                currentUser = emailAdd;
                return 1;
            }
            else {
                return -1;
            }
        }
        return -2;
    }

    private String currentUser;
    private Map<String, UserProfile> registeredUsers = new HashMap<>();
    private static AppModel instance = new AppModel();
}
