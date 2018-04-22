package edu.fau.oosd.group9.rentacar;

public class MidSize extends CarAbstract {

    String price = "$30/day";
    String vehicleClass = "Mid-Size";

    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    @Override
    public String getPrice() {
        return price;
    }
}
