package edu.fau.oosd.group9.rentacar;

/**
 * Abstract class for a vehicle class Car object that implements Car interface.
 * Defines some methods so that we don't have to repeat code for all prototypes.
 */
public abstract class CarAbstract implements Car {

    /**
     * Gets the price to rent the vehicle class for one day.
     * @return the price to rent the vehicle class for one day
     */
    @Override
    public abstract int getPrice();

    /**
     * Gets the name of the vehicle class.
     * @return the name of the vehicle class
     */
    @Override
    public abstract String getVehicleClass();

    /**
     * Supports cloning.
     * @return a clone of the Car object
     * @throws CloneNotSupportedException
     */
    @Override
    public Car clone() throws CloneNotSupportedException{
        return (Car) super.clone();
    }
}
