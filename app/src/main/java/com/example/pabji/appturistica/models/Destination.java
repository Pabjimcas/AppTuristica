package com.example.pabji.appturistica.models;

/**
 * Created by pabji on 01/06/2016.
 */
public class Destination {
    String name;
    String image_url;

    public Destination(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
