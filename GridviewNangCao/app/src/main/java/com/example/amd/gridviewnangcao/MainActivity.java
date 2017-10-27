package com.example.amd.gridviewnangcao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    ArrayList<HinhAnh> arrhayhinhanh;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new HinhAnhAdapter(this,R.layout.donganhdong,arrhayhinhanh);
        gv.setAdapter(adapter);
    }
    private void AnhXa(){
        gv=(GridView)findViewById(R.id.Gridview);
        arrhayhinhanh = new ArrayList<>();
        arrhayhinhanh.add(new HinhAnh(R.drawable.fire,"Hinh so 1"));
        arrhayhinhanh.add(new HinhAnh(R.drawable.dragon,"Hinh so 2"));
        arrhayhinhanh.add(new HinhAnh(R.drawable.mango,"Hinh so 3"));
    }
}
