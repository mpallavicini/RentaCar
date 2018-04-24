package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;

/**
 * Holds the list of cars.
 * @author Justin + Ohm
 */
public class CarList {

    /**
     * Adds a car (vehicle class) to the list.
     * @param car the Car object to add to the list
     */
    public void add(Car car) {
        carList.put(car.getVehicleClass(), car);
    }

    /**
     * Gets car (vehicle class) from the list given the name as a string.
     * @param carType the name of the car Object to retrieve
     * @return a Car object corresponding to carType
     */
    public CarAbstract get(String carType){
        Car car = null;
        try{
            car = carList.get(carType).clone();
        } catch(Exception e) {
            System.out.println(e);
        }
        return (CarAbstract) car;
    }

    /**
     * Clears the car (vehicle class) list.
     */
    public void remove() {
        carList.clear();
    }

    /**
     * Checks if the list of cars (vehicle class) is empty.
     * @return true if empty, false if not empty
     */
    public Boolean isEmpty() {
        return carList.isEmpty();
    }

    private HashMap<String, Car> carList = new HashMap();
}
