package edu.fau.oosd.group9.rentacar;

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

    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpDate;
    private String pickUpTime;
    private String dropOffDate;
    private String dropOffTime;
}
