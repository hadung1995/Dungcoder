package com.example.amd.student_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    Database db=new Database(StudentActivity.this);
    StudentAdapter adapter;
    ArrayList<Student> arrayList=new ArrayList<>();
    ListView lv;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        lv=(ListView)findViewById(R.id.lv12312);
        id=getIntent().getExtras().getInt("class_id");
        dodulieu();
    }
    public void dodulieu(){
        arrayList=db.xemStudent(id);
//        adapter=new StudentAdapter(StudentActivity.this,arrayList);
//        lv.setAdapter(adapter);
    }
}
