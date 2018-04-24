package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;
import java.util.Map;

/**
 * Model that stores data for the app.
 * @author Justin + Ohm
 */

public class AppModel {

    /**
     * Getter for an instance of AppModel so that classes can retrieve data
     * @return
     */
    public static AppModel getInstance() {
        return instance;
    }

    /**
     * Add a new user (UserProfile) to the model
     * @param emailAdd
     * @param password
     */
    public void addNewUser(String emailAdd, String password) {
        UserProfile newUser = new UserProfile(emailAdd, password);
        registeredUsers.put(emailAdd, newUser);
        currentUser = newUser;
    }

    /**
     * Getter for the current logged in user
     * @return UserProfile object of the current logged in user
     */
    public UserProfile getCurrentUser() {
        return currentUser;
    }

    /**
     * Authenticates a user from the login screen against existing registered users
     * @param emailAdd the email the user enters on the login screen
     * @param inpPassword the password the user enters on the login screen
     * @return 1 if authenticated, -1 if password is incorrect, -2 if email not registered
     */
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

    /**
     * Adds a reservation submitted by the current logged on user to the user's profile
     * @param newReservation an instance of the new reservation to save to the user's profile
     */
    public void addReservationForCurrentUser(Reservation newReservation) {
        currentUser.addUserReservation(newReservation);
    }

    /**
     * Add a car to CarList
     * @param car a car object
     */
    public void addToCarList(CarAbstract car){
        carList.add(car);
    }

    /**
     * Remove a car from CarList
     */
    public void removeFromCarList(){
        carList.remove();
    }

    /**
     * Checks if the car list is empty
     * @return true or false whether car list is empty
     */
    public Boolean isEmptyFromCarList(){
        return carList.isEmpty();
    }

    /**
     * Adds a reservation option to OptionsList
     * @param ao additional option to add
     */
    public void addToOptionsList(AdditionalOptions ao){
        addOptionsList.add(ao);
    }

    /**
     * Removes a reservation option from the OptionsList
     * @param ao additional option to remove
     */
    public void removeFromOptionsList(AdditionalOptions ao) { addOptionsList.remove(ao); }

    /**
     * Checks if the OptionList is empty
     * @return true or false whether OptionList is empty
     */
    public Boolean isEmptyFromOptionList(){
        return addOptionsList.isEmpty();
    }

    /**
     * Getter that returns the name stored in the current user's profile
     * @return the user's name
     */
    public String getNameFromUserProfile(){
        return currentUser.getUserName();
    }

    /**
     * Getter that returns the address stored in the current user's profile
     * @return the user's address
     */
    public String getAddressFromUserProfile(){
        return currentUser.getUserAddress();
    }

    /** Getter that returns the phone number stored in the current user's profile
     * @return the user's phone number
     */
    public String getPhoneFromUserProfile(){
        return currentUser.getUserPhone();
    }

    /**
     * Getter that returns the driver license number stored in the current user's profile
     * @return the user's driver license number
     */
    public String getDriverFromUserProfile(){
        return currentUser.getUserDL();
    }

    private UserProfile currentUser;
    private Map<String, UserProfile> registeredUsers = new HashMap<>();
    private CarList carList = new CarList();
    private AddOptionsList addOptionsList = new AddOptionsList();
    private static AppModel instance = new AppModel();
}
