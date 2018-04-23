package edu.fau.oosd.group9.rentacar;

public interface Car extends Cloneable {
    int getPrice();
    String getVehicleClass();
    Car clone() throws CloneNotSupportedException;
}
