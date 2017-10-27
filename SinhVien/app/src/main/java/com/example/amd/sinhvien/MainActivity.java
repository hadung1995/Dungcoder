package com.example.amd.sinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> arraystudent;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new StudentAdapter(this,R.layout.student,arraystudent);
        lv.setAdapter(adapter);
    }
    private void  Anhxa(){
        lv=(ListView)findViewById(R.id.listviewTraicay);
        arraystudent = new ArrayList<>();
        arraystudent.add(new Student(1,"Ha Thanh Dung",R.drawable.dragon));
    }

}
