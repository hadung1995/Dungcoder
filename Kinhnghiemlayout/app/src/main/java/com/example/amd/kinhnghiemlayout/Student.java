package com.example.amd.kinhnghiemlayout;

/**
 * Created by AMD on 10/5/2017.
 */

public class Student {
    private String student_id;
    private String student_name;

    public Student(String student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
