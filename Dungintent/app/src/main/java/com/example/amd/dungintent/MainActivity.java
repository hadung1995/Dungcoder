package com.example.amd.dungintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayname;
    ImageView imggoc,imgnhan;
    int Request_code=123;
    String tenhinh="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imggoc=(ImageView)findViewById(R.id.imageView);
        imgnhan=(ImageView)findViewById(R.id.imageView2);

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayname = new ArrayList<>(Arrays.asList(mangTen));

        tenhinh=arrayname.get(5);
        Collections.shuffle(arrayname);


        int id_hinh=getResources().getIdentifier(arrayname.get(5),"drawable",getPackageName());

        imggoc.setImageResource(id_hinh);
        imgnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivityForResult(new Intent(MainActivity.this,Main2Activity.class),Request_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==requestCode && resultCode==RESULT_OK && data!=null){
            String tenHinhnhan = data.getStringExtra("tenhinhchon");
            int idhinhnhan = getResources().getIdentifier(tenHinhnhan,"drawable",getPackageName());
            imgnhan.setImageResource(idhinhnhan);
            if(tenhinh.equals(tenHinhnhan)){
                Toast.makeText(this, "Dung roi", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Sai roi", Toast.LENGTH_SHORT).show();
            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
