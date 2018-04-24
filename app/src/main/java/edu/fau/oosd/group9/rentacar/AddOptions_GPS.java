package edu.fau.oosd.group9.rentacar;

/**
 * A GPS option object.
 * @author Justin + Ohm
 */
public class AddOptions_GPS extends AdditionalOptionsAbstract {

    int price = 10;
    String option = "GPS";

    /**
     * Gets the price of the GPS option.
     * @return the price of the GPS option
     */
    @Override
    public int getPrice(){
        return price;
    }

    /**
     * Gets the name of the GPS option.
     * @return the name of the GPS option
     */
    @Override
    public String getOption(){
        return option;
    }
}
