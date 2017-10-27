package com.example.amd.taisaodunghomquanhungsaihomnay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ImageView imggoc,imgnhan;
    public static ArrayList<String> arrayname;
    int request_code=123;
    String tenhinh="";
    TextView tv;
    int total=100;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imggoc=(ImageView)findViewById(R.id.imageView);
        imgnhan=(ImageView)findViewById(R.id.imageView3);
        tv=(TextView)findViewById(R.id.textView2);
        sharedPreferences = getSharedPreferences("diemsogame",MODE_PRIVATE);
        total=sharedPreferences.getInt("diem",100);
        tv.setText(""+total);

        String[] mangten =getResources().getStringArray(R.array.list_name);
        arrayname = new ArrayList<>(Arrays.asList(mangten));
        Collections.shuffle(arrayname);
        tenhinh=arrayname.get(0);
        int idhinhnhan = getResources().getIdentifier(arrayname.get(0),"drawable",getPackageName());
        imggoc.setImageResource(idhinhnhan);
        imgnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Imageactivity.class);
                startActivityForResult(intent,request_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request_code&&resultCode==RESULT_OK&&data!=null){
            String tenhinhnhan=data.getStringExtra("hinhnenne");
            int idkhac=getResources().getIdentifier(tenhinhnhan,"drawable",getPackageName());
            imgnhan.setImageResource(idkhac);
            if(tenhinh.equals(tenhinhnhan)){
                    Toast.makeText(this, "Chọn đúng rồi", Toast.LENGTH_SHORT).show();
                    total+=10;
                    Luudiem();
            }
            else {
                Toast.makeText(this, "Chọn sai rồi", Toast.LENGTH_SHORT).show();
                total-=5;
                Luudiem();
            }
            tv.setText(""+total);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void Luudiem(){
        SharedPreferences.Editor share = sharedPreferences.edit();
        share.putInt("diem",total);
        share.commit();
    }
}
