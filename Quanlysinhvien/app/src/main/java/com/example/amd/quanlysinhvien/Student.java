package com.example.amd.quanlysinhvien;

/**
 * Created by AMD on 9/28/2017.
 */

public class Student {
    private int student_id;
    private String student_name;
    private String mon_hoc;
    private String dob;
    static public int soluong;

    public Student(int student_id, String student_name, String mon_hoc, String dob) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.mon_hoc = mon_hoc;
        this.dob = dob;
    }

    public Student(){
        this.student_id=0;
        this.student_name="";
        this.mon_hoc="";
        this.dob="";
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

    public String getMon_hoc() {
        return mon_hoc;
    }

    public void setMon_hoc(String mon_hoc) {
        this.mon_hoc = mon_hoc;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String toString()
    {
        return "Id:"+this.student_id+" - Name:"+this.student_name+"  mon hoc: "+mon_hoc+"   dob: "+dob;
    }
}
