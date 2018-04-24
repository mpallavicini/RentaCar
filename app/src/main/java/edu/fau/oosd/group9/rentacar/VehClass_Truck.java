package edu.fau.oosd.group9.rentacar;

/**
 * A truck vehicle class object.
 */
public class VehClass_Truck extends CarAbstract {

    int price = 60;
    String vehicleClass = "Truck";

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
