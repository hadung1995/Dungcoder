package com.example.amd.dungintent2;

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
    ImageView imggoc,imgnhan;
    public static ArrayList<String> arrayname;
    int Request_code=123;
    String tenhinh="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imggoc=(ImageView)findViewById(R.id.imageView);
        imgnhan=(ImageView)findViewById(R.id.imageView2);
        String[] mangten = getResources().getStringArray(R.array.list_name);
        arrayname = new ArrayList<>(Arrays.asList(mangten));

        Collections.shuffle(arrayname);
        tenhinh=arrayname.get(0);
        int idhinh=getResources().getIdentifier(arrayname.get(0),"drawable",getPackageName());
        imggoc.setImageResource(idhinh);

        imgnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,Request_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==Request_code&&resultCode==RESULT_OK&& data!=null){
            String tenhinhnhan = data.getStringExtra("tenhinhchon");
            int idhinhnhan =getResources().getIdentifier(tenhinhnhan,"drawable",getPackageName());
            imgnhan.setImageResource(idhinhnhan);
            if(tenhinh.equals(tenhinhnhan)){
                Toast.makeText(this, "Dung roi", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Sai roi", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
