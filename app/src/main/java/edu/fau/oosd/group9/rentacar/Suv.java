package edu.fau.oosd.group9.rentacar;

public class Suv implements CarInterface {

    String price = "$50/day";
    String vehicleClass = "SUV";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    public String getPrice() {
        return price;
    }
}
