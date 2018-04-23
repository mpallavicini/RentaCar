package edu.fau.oosd.group9.rentacar;

public class AddOptions_SatelliteRadio extends AdditionalOptionsAbstract {

    int price = 5;
    String option = "Satellite Radio";

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public String getOption(){
        return option;
    }
}
