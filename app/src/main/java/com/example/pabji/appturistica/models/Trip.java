package com.example.pabji.appturistica.models;

/**
 * Created by pabji on 01/06/2016.
 */
public class Trip extends Destination {
    String trip_url;

    public Trip(String name, String image_url, String trip_url) {
        super(name, image_url);
        this.trip_url = trip_url;
    }

    public String getTrip_url() {
        return trip_url;
    }

    public void setTrip_url(String trip_url) {
        this.trip_url = trip_url;
    }
}
