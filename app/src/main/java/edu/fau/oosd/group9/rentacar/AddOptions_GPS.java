package edu.fau.oosd.group9.rentacar;

public class AddOptions_GPS extends AdditionalOptionsAbstract {

    int price = 10;
    String option = "GPS";

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }
}
