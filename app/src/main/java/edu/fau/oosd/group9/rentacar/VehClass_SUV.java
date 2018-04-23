package edu.fau.oosd.group9.rentacar;

public class VehClass_SUV extends CarAbstract {

    int price = 50;
    String vehicleClass = "SUV";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
