package com.example.amd.dungintent5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ImageView imggoc,imgnhan;
    TextView tv;
    public static ArrayList<String> arrayname;
    int request_code=123;
    String tenhinh="";
    SharedPreferences sharedPreferences;
    int total=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imggoc=(ImageView)findViewById(R.id.imageView);
        imgnhan=(ImageView)findViewById(R.id.imageView2);
        tv=(TextView)findViewById(R.id.textView2) ;
        sharedPreferences= getSharedPreferences("diemsogame",MODE_PRIVATE);

        total=sharedPreferences.getInt("diem",100);

        tv.setText(""+total);


        String[] mangten = getResources().getStringArray(R.array.list_name);
        arrayname = new ArrayList<>(Arrays.asList(mangten));
        Collections.shuffle(arrayname);
        tenhinh=arrayname.get(5);
        int idhinh= getResources().getIdentifier(arrayname.get(5),"drawable",getPackageName());
        imggoc.setImageResource(idhinh);

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
            String tenhinhnhan=data.getStringExtra("hinhneongnoi");

            int idhinhnhan=getResources().getIdentifier(tenhinhnhan,"drawable",getPackageName());
            imgnhan.setImageResource(idhinhnhan);
            if(tenhinh.equals(tenhinhnhan)){
                total+=10;
                Luudiem();
                Toast.makeText(this, "Đúng rồi ban được cộng: "+total, Toast.LENGTH_SHORT).show();
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayname);
                        tenhinh=arrayname.get(5);
                        int idhinh= getResources().getIdentifier(arrayname.get(5),"drawable",getPackageName());
                        imggoc.setImageResource(idhinh);
                    }

                }.start();
            }
            else{
                total-=5;
                Luudiem();
                Toast.makeText(this, "Sai rồi bạn bị trừ: "+total, Toast.LENGTH_SHORT).show();
            }
            tv.setText(""+total);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void Luudiem(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("diem",total);
        editor.commit();
    }
}
