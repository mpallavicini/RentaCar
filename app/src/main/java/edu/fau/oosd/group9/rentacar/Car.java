package edu.fau.oosd.group9.rentacar;

public interface Car extends Cloneable {

    String getPrice();
    String getVehicleClass();

    Car clone() throws CloneNotSupportedException;
}
