package edu.fau.oosd.group9.rentacar;

import java.util.ArrayList;

public class Reservation {

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public void setReservedCar(CarAbstract selectedCar) {
        this.reservedCar = selectedCar;
    }

    public void addAdditionalOptions(AdditionalOptionsAbstract addOption) {
        this.selectedOptions.add(addOption);
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public CarAbstract getReservedCar() {
        return reservedCar;
    }

    public ArrayList<AdditionalOptionsAbstract> getSelectedOptions() {
        return selectedOptions;
    }

    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpDate;
    private String pickUpTime;
    private String dropOffDate;
    private String dropOffTime;
    private CarAbstract reservedCar;
    private ArrayList<AdditionalOptionsAbstract> selectedOptions = new ArrayList<>();
}
