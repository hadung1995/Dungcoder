package com.example.amd.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rutbai;
    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;
    int sonut=0;//de xet xem duoc may nut
    int darut=0;//chi cho rut 3 la
    boolean batay=true;//de xet truong hop 3 tay
    String chuoithongbao="";
    ArrayList<String> cacladarut=new ArrayList<String>();//chua ten la da rut;

    //de de lam nen cho mang[][0] khong co y nghia (chi dung mang[][1]tro di
    int manghinhbai[][]={
            {R.drawable.b2fv,
                    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck},

            {R.drawable.b2fv,
                    R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
                    R.drawable.dj,R.drawable.dq,R.drawable.dk},

            {R.drawable.b2fv,
                    R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
                    R.drawable.hj,R.drawable.hq,R.drawable.hk},

            {R.drawable.b2fv,
                    R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk}
    };
    String mangtenbai[][]={
            {"rong",
                    "ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
                    "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
                    "boi chuon","dam chuon","gia chuon"},

            {"rong",
                    "ach ro","hai ro","ba ro","bon ro","nam ro",
                    "sau ro","bay ro","tam ro","chin ro","muoi ro",
                    "boi ro","dam ro","gia ro"},

            {"rong",
                    "ach co","hai co","ba co","bon co","nam co",
                    "sau co","bay co","tam co","chin co","muoi co",
                    "boi co","dam co","gia co"},

            {"rong",
                    "ach bich","hai bich","ba bich","bon bich","nam bich",
                    "sau bich","bay bich","tam bich","chin bich","muoi bich",
                    "boi bich","dam bich","gia bich"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai=(Button)findViewById(R.id.rutbai);
        labai1=(ImageView)findViewById(R.id.ivlabai1);
        labai2=(ImageView)findViewById(R.id.ivlabai2);
        labai3=(ImageView)findViewById(R.id.ivlabai3);
        thongbao=(TextView)findViewById(R.id.txtthongbao);

        //Rut bai
        rutbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(darut==0)
                {
                    darut=0;
                    sonut=0;
                    batay=true;
                    chuoithongbao="";
                    labai1.setImageResource(R.drawable.b2fv);
                    labai2.setImageResource(R.drawable.b2fv);
                    labai3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();
                }
                darut++;
                //Lay 2 số ngẫu nhiên để gán vào mảng 2 chiều dùng để tính nút
                Random r = new Random();
                int x=r.nextInt(4);
                int y=r.nextInt(13)+1;
                if(y<11){batay=false;}
                //Rút lá bài thứ 1
                if(darut==1)
                {
                    if(y<10)
                    {
                        sonut=sonut+y;
                    }
                    else
                    {
                        sonut=sonut+0;
                    }
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                if(darut==2)
                {
                    if(y<10)
                    {
                        sonut=sonut+y;
                    }
                    else
                    {
                        sonut=sonut+0;
                    }
                    labai2.setImageResource(manghinhbai[x][y]);
                }

                if(darut==3)
                {
                    if(y<10)
                    {
                        sonut=sonut+y;
                    }
                    else
                    {
                        sonut=sonut+0;
                    }
                    labai3.setImageResource(manghinhbai[x][y]);
                    darut=0;
                    int kq=sonut%10;
                    chuoithongbao="Tong 3 la bai: "+kq;
                }
                //Xét xem 3 lá bài đã có sẵn trong arraylist hay chưa?
                while(true)
                {
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
                thongbao.setText("Cac la da rut"+cacladarut.toString()
                        +chuoithongbao );
            }
        });

    }
}
