package com.example.amd.sinhvien;

/**
 * Created by AMD on 10/4/2017.
 */

public class Student {
    private int Student_id;
    private String Student_name;
    private int Hinh;

    public Student(int student_id, String student_name, int hinh) {
        Student_id = student_id;
        Student_name = student_name;
        Hinh = hinh;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
