package edu.fau.oosd.group9.rentacar;

public class VehClass_Compact extends CarAbstract {

    int price = 20;
    String vehicleClass = "Compact";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
