package edu.fau.oosd.group9.rentacar;

public interface AdditionalOptions extends Cloneable {
    int getPrice();
    String getOption();
    AdditionalOptions clone() throws CloneNotSupportedException;
}
