package edu.fau.oosd.group9.rentacar;

/**
 * Created by Ohm on 04/14/2018.
 */

public class UserProfile {

    public UserProfile(String emaildAdd, String password) {
        userEmailAddress = emaildAdd;
        userPassword = password;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    private String userName;
    private String userEmailAddress;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private String userDL;

}
