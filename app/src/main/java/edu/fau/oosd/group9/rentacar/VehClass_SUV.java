package edu.fau.oosd.group9.rentacar;

/**
 * An SUV vehicle class object.
 */
public class VehClass_SUV extends CarAbstract {

    int price = 50;
    String vehicleClass = "SUV";

    /**
     * Gets the name of the vehicle class.
     * @return the name of the vehicle class
     */
    @Override
    public String getVehicleClass() {
        return vehicleClass;
    }

    /**
     * Gets the price to rent the vehicle class for one day.
     * @return the price to rent the vehicle class for one day
     */
    @Override
    public int getPrice() {
        return price;
    }
}
