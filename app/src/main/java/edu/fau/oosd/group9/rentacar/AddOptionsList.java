package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;


/**
 *
 */
public class AddOptionsList {

    HashMap<String, AdditionalOptions> optionList = new HashMap();

    /**
     * @param option
     */
    public void add(AdditionalOptions option){
        optionList.put(option.getOption(), option);
    }

    /**
     * @param optionType
     * @return
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
     * @param ao
     */
    public void remove(AdditionalOptions ao){
        optionList.remove(ao);
    }

    /**
     * @return
     */
    public Boolean isEmpty(){
        return optionList.isEmpty();
    }
}
