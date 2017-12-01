package com.example.amd.student_manager;

/**
 * Created by AMD on 12/1/2017.
 */

public class Course {
    int id;
    String name;
    String phone;

    public Course(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Course(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
