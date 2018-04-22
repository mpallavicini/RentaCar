package edu.fau.oosd.group9.rentacar;

public abstract class CarAbstract implements Car {



    @Override
    public Car clone() throws CloneNotSupportedException{
        return (Car) super.clone();
    }

}
