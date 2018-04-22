package edu.fau.oosd.group9.rentacar;

public class VehicleInsurance implements AdditionalOptions {

    String price = "15/day";
    String option = "Vehicle Insurance";

    @Override
    public String getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }

}
