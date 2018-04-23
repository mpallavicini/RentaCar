package edu.fau.oosd.group9.rentacar;

public abstract class CarAbstract implements Car {

    @Override
    public abstract int getPrice();

    public abstract String getVehicleClass();

    @Override
    public Car clone() throws CloneNotSupportedException{
        return (Car) super.clone();
    }
}
