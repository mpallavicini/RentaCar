package edu.fau.oosd.group9.rentacar;

import java.util.ArrayList;

/**
 * User profile class that stores an instance of a user
 */
public class UserProfile {

    /**
     * Constructor for the user profile
     * @param emaildAdd the user's email address
     * @param password the user's password
     */
    public UserProfile(String emaildAdd, String password) {
        userEmailAddress = emaildAdd;
        userPassword = password;
        userReservations = new ArrayList<>();

        userName = "";
        userAddress = "";
        userPhone = "";
        userDL = "";
    }

    /**
     * Getter that returns the user's email address
     * @return the user's email address
     */
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    /**
     * Getter that returns the user's password
     * @return the user's password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Getter that returns the user's name
     * @return the user's name
     */
    public String getUserName() { return userName; }

    /**
     * Getter that returns the user's address
     * @return the user's address
     */
    public String getUserAddress() { return userAddress; }

    /**
     * Getter that returns the user's phone number
     * @return the user's phone number
     */
    public String getUserPhone() { return userPhone; }

    /**
     * Getter that returns the user's driver license number
     * @return the user's driver license number
     */
    public String getUserDL() { return userDL; }

    /**
     * Stores a new name for the user
     * @param userName the user's new name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Stores a new password for the user
     * @param userPassword the user's new password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Stores a new phone number for the user
     * @param userPhone the user's new phone number
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Stores a new address for the user
     * @param userAddress the user's new address
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * Stores a new driver license number for the user
     * @param userDL the user's new driver license number
     */
    public void setUserDL(String userDL) {
        this.userDL = userDL;
    }

    /**
     * Associates a new reservation with the user
     * @param newReservation
     */
    public void addUserReservation(Reservation newReservation) {
        userReservations.add(newReservation);
    }

    /**
     * Getter that returns the reservations associated with the user
     * @return an arraylist containing the Reservations associated with the user
     */
    public ArrayList<Reservation> getUserReservations() {
        return userReservations;
    }

    /**
     * Getter that returns the latest reservation created by the user
     * @return a Reservation object of the user's newest reservation
     */
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
