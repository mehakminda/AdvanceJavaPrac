package com.learning.embark.kafkaconsumer2;


public class RiderLocation {
    private String riderId;
    private double latitude;
    private double longitude;

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public RiderLocation(String riderId, double latitude, double longitude) {
        this.riderId = riderId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "RiderLocation{" +
                "riderId='" + riderId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
    //ADDED below as was getting this:
    //Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.learning.embark.kafkaconsumer2.RiderLocation` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
    // at [Source: UNKNOWN; line: 1, column: 2]

    public RiderLocation() {
    }
}
