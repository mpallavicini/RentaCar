package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;


public class OptionList {

    HashMap<String, AdditionalOptions> optionList = new HashMap();

    public void add(AdditionalOptions option){
        optionList.put(option.getOption(), option);
    }

    public AdditionalOptions get(String optionType){
        AdditionalOptions option = null;
        try{
            option = optionList.get(optionType).clone();
        }catch(Exception e) {
            System.out.println(e);
        }
        return option;
    }

    public void remove(AdditionalOptions ao){
        optionList.remove(ao);
    }

    public Boolean isEmpty(){
        return optionList.isEmpty();
    }
}
