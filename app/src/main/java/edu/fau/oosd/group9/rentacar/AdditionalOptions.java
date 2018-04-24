package edu.fau.oosd.group9.rentacar;

/**
 * The default interface for additional reservation options and
 * contains methods that must be implemented.
 */
public interface AdditionalOptions extends Cloneable {

    /**
     * Gets the price of the additional option.
     * @return the price of the additional option
     */
    int getPrice();

    /**
     * Gets the name of the additional option.
     * @return the name of the additional option
     */
    String getOption();

    /**
     * Supports cloning.
     * @return a clone of the AdditionalOption object
     * @throws CloneNotSupportedException
     */
    AdditionalOptions clone() throws CloneNotSupportedException;
}
