package com.example.amd.assignmenmap;

/**
 * Created by AMD on 12/7/2017.
 */

public class User {
    int id;
    String username;
    String password;
    String name;
    String dob;

    public User(int id, String username, String password, String name, String dob) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }

    public User(String username, String password, String name, String dob) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }
}
