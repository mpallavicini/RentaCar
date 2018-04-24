package edu.fau.oosd.group9.rentacar;

/**
 * The default interface for a Car object vehicle class) and
 * contains methods that must be implemented.
 */
public interface Car extends Cloneable {

    /**
     * Gets the price to rent the vehicle class for one day.
     * @return the price to rent the vehicle class for one day
     */
    int getPrice();

    /**
     * Gets the name of the vehicle class.
     * @return the name of the vehicle class
     */
    String getVehicleClass();

    /**
     * Supports cloning.
     * @return a clone of the Car object
     * @throws CloneNotSupportedException
     */
    Car clone() throws CloneNotSupportedException;
}
