package edu.fau.oosd.group9.rentacar;

public class VehClass_Crossover extends CarAbstract {

    int price = 40;
    String vehicleClass = "Crossover";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
