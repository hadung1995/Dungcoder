package com.example.amd.testplan4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvtraicay;
    ArrayList<Student> arrtraicay;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new StudentAdapter(this,R.layout.student_list,arrtraicay);
        lvtraicay.setAdapter(adapter);
    }
    private void Anhxa(){
        lvtraicay=(ListView)findViewById(R.id.listview123);
        arrtraicay = new ArrayList<>();
        arrtraicay.add(new Student("Chuối","Banana",R.drawable.dragon));

    }

}
