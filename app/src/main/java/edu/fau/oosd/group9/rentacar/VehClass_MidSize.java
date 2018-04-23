package edu.fau.oosd.group9.rentacar;

public class VehClass_MidSize extends CarAbstract {

    int price = 30;
    String vehicleClass = "Mid-Size";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
