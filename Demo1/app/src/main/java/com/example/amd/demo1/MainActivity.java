package com.example.amd.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lw;
    ArrayList<java> javas;
    javaadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new javaadapter(this,R.layout.dongdemo,javas);
        lw.setAdapter(adapter);
    }

    private void AnhXa() {
        lw=(ListView)findViewById(R.id.listview);
        javas = new ArrayList<>();
        javas.add(new java("nguyen","van"));
    }
}
//ong khong lam viewholder ha ong?
//toi lam viewholder de tiet kiem bo nho
// =)  toi k
// oong lafm theem ddi
//u doi toi xiu
