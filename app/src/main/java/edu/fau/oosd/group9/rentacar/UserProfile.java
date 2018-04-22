package edu.fau.oosd.group9.rentacar;

import java.util.ArrayList;

/**
 * Created by Ohm on 04/14/2018.
 */

public class UserProfile {

    public UserProfile(String emaildAdd, String password) {
        userEmailAddress = emaildAdd;
        userPassword = password;
        userReservations = new ArrayList<>();
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void addUserReservation(Reservation newReservation) {
        userReservations.add(newReservation);
        //String test = "hello";
    }

    public ArrayList<Reservation> getUserReservations() {
        return userReservations;
    }

    public Reservation getLastReservation() {
        return userReservations.get(userReservations.size()-1);
    }

    private String userName;
    private String userEmailAddress;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private String userDL;
    private ArrayList<Reservation> userReservations;

}
