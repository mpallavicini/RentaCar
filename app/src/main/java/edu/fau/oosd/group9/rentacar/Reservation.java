package edu.fau.oosd.group9.rentacar;

import java.util.ArrayList;

/**
 * Reservation class that stores an instances of a reservation
 * @author Ohm
 */
public class Reservation {

    /**
     * Stores the pickup location for the reservation
     * @param pickUpLocation the name of the pickup location
     */
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    /**
     * Stores the pickup date for the reservation
     * @param pickUpDate the text of the pickup date
     */
    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    /**
     * Stores the pickup time for the reservation
     * @param pickUpTime the text of the pickup time
     */
    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    /**
     * Stores the dropoff location for the reservation
     * @param dropOffLocation the name of the dropoff location
     */
    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    /**
     * Stores the dropoff date for the reservation
     * @param dropOffDate the text of the dropoff date
     */
    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    /**
     * Stores the dropoff time for the reservation
     * @param dropOffTime the text of the dropoff time
     */
    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    /**
     * Stores the selected car (vehicle class) for the reservation
     * @param selectedCar the CarAbstract object of the selected vehicle class
     */
    public void setReservedCar(CarAbstract selectedCar) {
        this.reservedCar = selectedCar;
    }

    /**
     * Stores an additional option selected by the user (can add multiple)
     * @param addOption the AdditionalOptionsAbstract object of the selected option to add
     */
    public void addAdditionalOptions(AdditionalOptionsAbstract addOption) {
        this.selectedOptions.add(addOption);
    }

    /**
     * Gets the pickup location stored in the reservation
     * @return the name of the pickup location
     */
    public String getPickUpLocation() {
        return pickUpLocation;
    }

    /**
     * Gets the pickup date stored in the reservation
     * @return the text of the pickup date
     */
    public String getPickUpDate() {
        return pickUpDate;
    }

    /**
     * Gets the pickup time stored in the reservation
     * @return the text of the pickup time
     */
    public String getPickUpTime() {
        return pickUpTime;
    }

    /**
     * Gets the dropoff location stored in the reservation
     * @return the name of the dropoff location
     */
    public String getDropOffLocation() {
        return dropOffLocation;
    }

    /**
     * Gets the dropoff date stored in the reservation
     * @return the text of the dropoff date
     */
    public String getDropOffDate() {
        return dropOffDate;
    }

    /**
     * Gets the dropoff time stored in the reservation
     * @return the text of the time
     */
    public String getDropOffTime() {
        return dropOffTime;
    }

    /**
     * Gets the car (vehicle class) stored in the reservation
     * @return the CarAbstract object
     */
    public CarAbstract getReservedCar() {
        return reservedCar;
    }

    /**
     * Gets the list of selected options stored in the reservation
     * @return an ArrayList of AdditionalOptionsAbstract objects
     */
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
