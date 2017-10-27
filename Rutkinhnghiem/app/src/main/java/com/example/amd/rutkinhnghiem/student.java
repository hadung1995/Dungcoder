package com.example.amd.rutkinhnghiem;

/**
 * Created by AMD on 9/29/2017.
 */

public class student {
    private int student_id;
    private String student_name;
    static public int soluong;
    public student(){
        student_id=0;
        student_name="";
    }
    public student(int student_id, String student_name) {
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
    public String toString(){
        return "Ho ten sinh vien: "+student_name+"----Ma so sinh vien:  "+student_id;
    }

}
