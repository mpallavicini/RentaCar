package edu.fau.oosd.group9.rentacar;

import java.util.ArrayList;

/**
 * Model for the user profile.
 */
public class UserProfile {

    public UserProfile(String emaildAdd, String password) {
        userEmailAddress = emaildAdd;
        userPassword = password;
        userReservations = new ArrayList<>();

        userName = "";
        userAddress = "";
        userPhone = "";
        userDL = "";
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() { return userName; }

    public String getUserAddress() { return userAddress; }

    public String getUserPhone() { return userPhone; }

    public String getUserDL() { return userDL; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserDL(String userDL) {
        this.userDL = userDL;
    }

    public void addUserReservation(Reservation newReservation) {
        userReservations.add(newReservation);
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
