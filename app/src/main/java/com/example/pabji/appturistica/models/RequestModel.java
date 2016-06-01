package com.example.pabji.appturistica.models;

/**
 * Created by pabji on 01/06/2016.
 */
public class RequestModel {
    String key;
    String latitude;
    String longitude;

    public RequestModel(String key, String latitude, String longitude) {
        this.key = key;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
