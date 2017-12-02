package com.example.amd.student_manager;

/**
 * Created by AMD on 12/2/2017.
 */

public class Class {
    int id;
    String name;
    String train;
    int course_id;

    public Class(int id, String name, String train, int course_id) {
        this.id = id;
        this.name = name;
        this.train = train;
        this.course_id = course_id;
    }

    public Class(String name, String train, int course_id) {
        this.name = name;
        this.train = train;
        this.course_id = course_id;
    }
}
