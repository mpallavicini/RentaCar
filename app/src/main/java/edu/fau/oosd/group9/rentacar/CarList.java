package edu.fau.oosd.group9.rentacar;

import java.util.HashMap;

public class CarList {

    HashMap<String, Car> carList = new HashMap();

    public void add(Car car){
        carList.put(car.getVehicleClass(), car);
    }

    public Car get(String carType){
        Car car = null;
        try{
            car = carList.get(carType).clone();
        }catch(Exception e) {
            System.out.println(e);
        }
        return car;
    }

    public void remove(){
        carList.clear();
    }

    public Boolean isEmpty(){
        return carList.isEmpty();
    }


}
