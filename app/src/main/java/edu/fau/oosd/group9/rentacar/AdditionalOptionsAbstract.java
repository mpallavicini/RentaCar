package edu.fau.oosd.group9.rentacar;

/**
 * Abstract class for additional reservation options that implements AdditionalOptions interface.
 * Defines clone so that we don't have to repeat code for all prototypes.
 * @author Justin + Ohm
 */
public abstract class AdditionalOptionsAbstract implements AdditionalOptions {

    /**
     * Supports cloning.
     * @return A clone of the AdditionalOptions object.
     * @throws CloneNotSupportedException
     */
    @Override
    public AdditionalOptions clone() throws CloneNotSupportedException{
        return (AdditionalOptions) super.clone();
    }
}
