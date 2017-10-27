package com.example.amd.lamlaigamechonhinhluusodiem;

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
        imgnhan=(ImageView)findViewById(R.id.imageView2);
        tv=(TextView)findViewById(R.id.textView2);
        sharedPreferences= getSharedPreferences("diemsogame1",MODE_PRIVATE);

        total=sharedPreferences.getInt("diem",100);

        tv.setText(""+total);


        //lay chuoi ky tu tu string array trong tai nguyen string
        String[] mangtenhinh= getResources().getStringArray(R.array.list_name);
        //luu mangtenhinh vao arraylist
        arrayname = new ArrayList<>(Arrays.asList(mangtenhinh));
        //thay doi vi tri cua hinh
        Collections.shuffle(arrayname);
        tenhinh=arrayname.get(0);
        //lay vi tri cua hinh
        int idhinh=getResources().getIdentifier(arrayname.get(0),"drawable",getPackageName());
        imggoc.setImageResource(idhinh);
        imgnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,request_code);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request_code&&resultCode==RESULT_OK&&data!=null){
            String tenhinhnhan=data.getStringExtra("tenhinhne");
            int idhinhnhan=getResources().getIdentifier(tenhinhnhan,"drawable",getPackageName());
            imgnhan.setImageResource(idhinhnhan);
            if(tenhinh.equals(tenhinhnhan)){
                total+=10;
                Luudiem();
                Toast.makeText(this, "Chọn đúng rồi", Toast.LENGTH_SHORT).show();

                new CountDownTimer(2000,100){

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayname);
                        tenhinh=arrayname.get(0);
                        //lay vi tri cua hinh
                        int idhinh=getResources().getIdentifier(arrayname.get(0),"drawable",getPackageName());
                        imggoc.setImageResource(idhinh);
                    }
                }.start();
            }
            else{
                total-=5;
                Luudiem();
                Toast.makeText(this, "Chon sai roi", Toast.LENGTH_SHORT).show();

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
