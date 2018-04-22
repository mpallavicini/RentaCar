package edu.fau.oosd.group9.rentacar;

public abstract class AdditionalOptionsAbstract implements AdditionalOptions {

    @Override
    public AdditionalOptions clone() throws CloneNotSupportedException{
        return (AdditionalOptions) super.clone();
    }
}
