package com.example.amd.ungdung1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout lineear;
    Button btn;
    ArrayList<Integer> array_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineear=(LinearLayout)findViewById(R.id.line);
        btn=(Button)findViewById(R.id.button);
        array_img=new ArrayList<>();
        array_img.add(R.drawable.image_nice);
        array_img.add(R.drawable.images_good);
        array_img.add(R.drawable.images_well);
        array_img.add(R.drawable.activity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rd = new Random();
                int vitri = rd.nextInt(array_img.size());
                lineear.setBackgroundResource(array_img.get(vitri));

            }
        });


    }
}
