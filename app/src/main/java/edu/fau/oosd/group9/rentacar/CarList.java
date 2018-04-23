package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;

public class CarList {

    public void add(Car car) {
        carList.put(car.getVehicleClass(), car);
    }

    public CarAbstract get(String carType){
        Car car = null;
        try{
            car = carList.get(carType).clone();
        } catch(Exception e) {
            System.out.println(e);
        }
        return (CarAbstract) car;
    }

    public void remove() {
        carList.clear();
    }

    public Boolean isEmpty() {
        return carList.isEmpty();
    }

    private HashMap<String, Car> carList = new HashMap();
}
