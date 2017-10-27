package com.example.amd.pissasolibrary_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://i.imgur.com/DvpvklR.png";
        img=(ImageView)findViewById(R.id.imageView);
        Picasso.with(MainActivity.this).load(url).into(img);

    }
}
