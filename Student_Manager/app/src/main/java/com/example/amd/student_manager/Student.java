package com.example.amd.student_manager;

/**
 * Created by AMD on 12/2/2017.
 */

public class Student {
    int id;
    String name;
    String dob;
    String sex;
    int class_id;
    byte[] picture;

    public Student(int id, String name, String dob, String sex, int class_id, byte[] picture) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.class_id = class_id;
        this.picture = picture;
    }

    public Student(String name, String dob, String sex, int class_id, byte[] picture) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.class_id = class_id;
        this.picture = picture;
    }
}
