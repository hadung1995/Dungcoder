package com.example.amd.ontapchotatca;

/**
 * Created by AMD on 10/7/2017.
 */

public class Student {
    private int student_id;
    private String student_name;
    private String student_dob;
    private String student_subject;
    static int soluong;

    public Student(){

        student_id=0;
        student_name="";
        student_dob="";
        student_subject="";
    }

    public Student(int student_id, String student_name, String student_dob, String student_subject) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_dob = student_dob;
        this.student_subject = student_subject;
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

    public String getStudent_dob() {
        return student_dob;
    }

    public void setStudent_dob(String student_dob) {
        this.student_dob = student_dob;
    }

    public String getStudent_subject() {
        return student_subject;
    }

    public void setStudent_subject(String student_subject) {
        this.student_subject = student_subject;
    }
    public String toString()
    {
        return "Id:"+this.student_id+" - Name:"+this.student_name+"  mon hoc: "+student_subject+"  dob: "+student_dob;
    }
}
