package edu.fau.oosd.group9.rentacar;

public class SatelliteRadio implements AdditionalOptions {

    String price = "5/day";
    String option = "Satalite Radio";

    @Override
    public String getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }
}
