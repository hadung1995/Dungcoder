package com.example.amd.thongtinsinhvien;

/**
 * Created by AMD on 9/28/2017.
 */

public class Student {

        private int student_id;
        private String student_name;
        static public int soluong;

        //Hàm tạo không đối số
        public Student()
        {
            student_id=0;
            student_name="";
        }
        //Hàm tạo 2 đối số
        public Student(int id, String name)
        {
            student_id=id;
            student_name=name;
        }
        //Phương thức get, set
        public int getStudent_id()
        {
            return student_id;
        }
        public String getStudent_name()
        {
            return student_name;
        }
        public void setStudent_id(int id)
        {
            this.student_id=id;
        }
        public void setStudent_name(String name)
        {
            this.student_name= name;
        }
        //Trả về thông tin sinh viên
        public String toString()
        {
            return "Id:"+this.student_id+" - Name:"+this.student_name;
        }
    }


