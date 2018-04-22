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

    public void addToCarList(Car car){
        carList.add(car);
    }

    public String getPriceFromCarList(String carName){
        return carList.get(carName).getPrice();
    }

    public void removeFromCarList(){
        carList.remove();
    }
    public Boolean isEmptyFromCarList(){
        return carList.isEmpty();
    }

    public void addToOptionList(AdditionalOptions ao){
        optionList.add(ao);
    }

    public String getPriceFromOptionList(String optionType){
        return optionList.get(optionType).getPrice();
    }

    public void removeFromOptionList(AdditionalOptions ao){
        optionList.remove(ao);
    }
    public Boolean isEmptyFromOptionList(){
        return optionList.isEmpty();
    }







    private String currentUser;
    private Map<String, UserProfile> registeredUsers = new HashMap<>();
    private static AppModel instance = new AppModel();

    private CarList carList = new CarList();
    private OptionList optionList = new OptionList();
}
