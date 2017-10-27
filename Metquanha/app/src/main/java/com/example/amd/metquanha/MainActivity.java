package com.example.amd.metquanha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> arrayStudent;
    studentadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter= new studentadapter(this,R.layout.studentlist,arrayStudent);
        lv.setAdapter(adapter);
    }
    private void AnhXa(){
        lv=(ListView)findViewById(R.id.listviewsinhvien);
        arrayStudent = new ArrayList<>();
        arrayStudent.add(new Student("Ha","Dung"));
    }
}
