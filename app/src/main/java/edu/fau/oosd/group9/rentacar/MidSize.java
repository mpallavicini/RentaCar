package edu.fau.oosd.group9.rentacar;

public class MidSize implements CarInterface {

    String price = "$30/day";
    String vehicleClass = "Mid-Size";

    @Override
    public String getVehicleClass() {
        return price;
    }

    public String getPrice() {
        return vehicleClass;
    }
}
