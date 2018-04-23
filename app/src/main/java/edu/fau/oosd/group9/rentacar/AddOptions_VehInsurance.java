package edu.fau.oosd.group9.rentacar;

public class AddOptions_VehInsurance extends AdditionalOptionsAbstract {

    int price = 15;
    String option = "Vehicle Insurance";

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }

}
