package edu.fau.oosd.group9.rentacar;

public class GPS implements AdditionalOptions {

    String price = "10/day";
    String option = "GPS";

    @Override
    public String getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }
}
