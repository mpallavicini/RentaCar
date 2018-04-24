package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;

/**
 * Holds the list of additional options.
 */
public class AddOptionsList {

    HashMap<String, AdditionalOptions> optionList = new HashMap();

    /**
     * Adds an additional option to the list.
     * @param option the AdditionalOptions object to add to the list
     */
    public void add(AdditionalOptions option){
        optionList.put(option.getOption(), option);
    }

    /**
     * Gets additional option from the list given the name as a string.
     * @param optionType the name of the option to retrieve
     * @return an AdditionalOptions object corresponding to optionType
     */
    public AdditionalOptions get(String optionType){
        AdditionalOptions option = null;
        try{
            option = optionList.get(optionType).clone();
        }catch(Exception e) {
            System.out.println(e);
        }
        return option;
    }

    /**
     * Removes an additional option from the list.
     * @param ao the AdditionalOptions object to remove from the list
     */
    public void remove(AdditionalOptions ao){
        optionList.remove(ao);
    }

    /**
     * Checks if the list of options is empty.
     * @return true if empty, false if not empty
     */
    public Boolean isEmpty(){
        return optionList.isEmpty();
    }
}
