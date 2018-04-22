package edu.fau.oosd.group9.rentacar;

public class SatelliteRadio extends AdditionalOptionsAbstract {

    String price = "5/day";
    String option = "Satellite Radio";

    @Override
    public String getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }
}
