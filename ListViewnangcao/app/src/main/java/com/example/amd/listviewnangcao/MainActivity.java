package com.example.amd.listviewnangcao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvtraicay;
    ArrayList<TraiCay> arrtraicay;
    TraiCayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        adapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,arrtraicay);
        lvtraicay.setAdapter(adapter);
    }
    private void Anhxa(){
        lvtraicay=(ListView)findViewById(R.id.listviewTraicay);
        arrtraicay = new ArrayList<>();
        arrtraicay.add(new TraiCay("Chuối","Banana",R.drawable.banana));
        arrtraicay.add(new TraiCay("Cam","Orange",R.drawable.orange));
        arrtraicay.add(new TraiCay("Xoài","Mango",R.drawable.mango));
    }
}
