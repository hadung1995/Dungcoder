package com.example.amd.assignmenmap;

/**
 * Created by AMD on 12/7/2017.
 */

public class Place {
    int id;
    String name;
    String address;
    Double latitude;
    Double longtitude;
    String description;
    byte[] picture;

    public Place(int id, String name, String address, Double latitude, Double longtitude, String description, byte[] picture) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.description = description;
        this.picture = picture;
    }

    public Place(String name, String address, Double latitude, Double longtitude, String description, byte[] picture) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.description = description;
        this.picture = picture;
    }

    public Place(String name, String address, Double latitude, Double longtitude, String description) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.description = description;
    }

    public Place() {
    }
}
