package edu.fau.oosd.group9.rentacar;

public class Truck extends CarAbstract {

    String price = "$60/day";
    String vehicleClass = "Truck";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    public String getPrice() {
        return price;
    }
}
