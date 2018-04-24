package edu.fau.oosd.group9.rentacar;

/**
 * A Vehicle Insurance option object.
 * @author Justin + Ohm
 */
public class AddOptions_VehInsurance extends AdditionalOptionsAbstract {

    int price = 15;
    String option = "Vehicle Insurance";

    /**
     * Gets the price of the Vehicle Insurance option.
     * @return the price of the Vehicle Insurance option.
     */
    @Override
    public int getPrice(){
        return price;
    }

    /**
     * Gets the name of the Vehicle Insurance option.
     * @return the name of the Vehicle Insurance option
     */
    @Override
    public String getOption(){
        return option;
    }

}
