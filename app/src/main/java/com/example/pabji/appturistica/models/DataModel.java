package com.example.pabji.appturistica.models;

import java.util.List;

/**
 * Created by pabji on 01/06/2016.
 */
public class DataModel {
    List<Destination> trips;
    List<Destination> destinations;

    public DataModel(List<Destination> trips, List<Destination> destinations) {
        this.trips = trips;
        this.destinations = destinations;
    }

    public List<Destination> getTrips() {
        return trips;
    }

    public void setTrips(List<Destination> trips) {
        this.trips = trips;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
