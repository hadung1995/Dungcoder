package com.example.amd.thatlacaycayqua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> arraystudent;
    adapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter1 = new adapter(this,R.layout.fucking,arraystudent);
        lv.setAdapter(adapter1);
    }
    private void AnhXa(){
        lv=(ListView)findViewById(R.id.listviewsinhvien);
        arraystudent = new ArrayList<>();
        arraystudent.add(new Student("Ha","Dung"));
    }
}
