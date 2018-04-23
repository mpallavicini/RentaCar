package edu.fau.oosd.group9.rentacar;

public class VehClass_Truck extends CarAbstract {

    int price = 60;
    String vehicleClass = "Truck";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
