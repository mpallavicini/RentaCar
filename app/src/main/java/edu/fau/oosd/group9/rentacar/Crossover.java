package edu.fau.oosd.group9.rentacar;

public class Crossover implements CarInterface {

    String price = "$40/day";
    String vehicleClass = "Crossover";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    public String getPrice() {
        return price;
    }
}
