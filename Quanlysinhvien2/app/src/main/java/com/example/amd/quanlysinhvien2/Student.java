package com.example.amd.quanlysinhvien2;

/**
 * Created by AMD on 9/28/2017.
 */

public class Student {
    private int student_id;
    private String student_name;
    static public int soluong;

    public Student()
    {
        student_id=0;
        student_name="";
    }
    public Student(int student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String toString()
    {
        return "Id:"+this.student_id+" - Name:"+this.student_name;
    }
}
