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
        registeredUsers.put(emailAdd, newUser);
        currentUser = newUser;
    }

    public UserProfile getCurrentUser() {
        return currentUser;
    }

    public void addReservationForCurrentUser(Reservation newReservation) {
        currentUser.addUserReservation(newReservation);
    }

    public int authenticateUser(String emailAdd, String inpPassword) {
        if(registeredUsers.containsKey(emailAdd)) {
            currentUser = registeredUsers.get(emailAdd);
            String regPassword = currentUser.getUserPassword();
            if(regPassword.equals(inpPassword)) {
                return 1;
            }
            else {
                return -1;
            }
        }
        return -2;
    }

    private UserProfile currentUser;
    private Map<String, UserProfile> registeredUsers = new HashMap<>();
    private static AppModel instance = new AppModel();
}
