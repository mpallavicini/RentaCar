package edu.fau.oosd.group9.rentacar;

public interface AdditionalOptions extends Cloneable {

    String getPrice();
    String getOption();

    AdditionalOptions clone() throws CloneNotSupportedException;
}
