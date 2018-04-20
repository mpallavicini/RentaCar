package edu.fau.oosd.group9.rentacar;

public class CompactVehicle implements CarInterface {

    String price = "$20/day";
    String vehicleClass = "Compact";

    @Override
    public String getVehicleClass() {
        return price;
    }

    public String getPrice() {
        return vehicleClass;
    }
}
