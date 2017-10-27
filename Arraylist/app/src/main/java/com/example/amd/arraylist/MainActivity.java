package com.example.amd.arraylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> mang=new ArrayList<>();
        mang.add("ios");
        mang.add("Nha trang");
        mang.add("Can Tho");
        for(String s : mang){
            Log.d("Gia tri: ",s);
        }
    }
}
