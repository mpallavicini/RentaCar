package edu.fau.oosd.group9.rentacar;

/**
 * A compact vehicle class object.
 */
public class VehClass_Compact extends CarAbstract {

    int price = 20;
    String vehicleClass = "Compact";

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
