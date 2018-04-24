package edu.fau.oosd.group9.rentacar;

/**
 * A Satellite Radio option object.
 * @author Justin + Ohm
 */
public class AddOptions_SatelliteRadio extends AdditionalOptionsAbstract {

    int price = 5;
    String option = "Satellite Radio";

    /**
     * Gets the price of the Satellite Radio option.
     * @return the price of the Satellite Radio option
     */
    @Override
    public int getPrice(){
        return price;
    }

    /**
     * Gets the name of the Satellite Radio option.
     * @return the name of the Satellite Radio option
     */
    @Override
    public String getOption(){
        return option;
    }
}
