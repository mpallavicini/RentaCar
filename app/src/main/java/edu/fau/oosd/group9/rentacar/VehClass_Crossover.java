package edu.fau.oosd.group9.rentacar;

/**
 * A crossover vehicle class object.
 * @author Justin
 */
public class VehClass_Crossover extends CarAbstract {

    int price = 40;
    String vehicleClass = "Crossover";

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
