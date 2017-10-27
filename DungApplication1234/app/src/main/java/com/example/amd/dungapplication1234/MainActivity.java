package com.example.amd.dungapplication1234;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> studentlist;
    Studentadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
       adapter = new Studentadapter(this,R.layout.student_list,studentlist);
        lv.setAdapter(adapter);
    }
    public void AnhXa(){
        lv=(ListView)findViewById(R.id.listviewTraicay);
       studentlist = new ArrayList<>();
        studentlist.add(new Student(1,"Ha Thanh Dung"));
    }
}
