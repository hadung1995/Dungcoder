package com.example.amd.chuongtrinhthaotacvoimangsonguyen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText nhapso;
    TextView tv;
    Button bt1,bt2,bt3,bt4,bt5,bt6;
    int myarr[]=new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.createran);
        bt2=(Button)findViewById(R.id.xuatxuoi);
        bt3=(Button)findViewById(R.id.xuatnguoc);
        bt4=(Button)findViewById(R.id.timmaxvamin);
        bt5=(Button)findViewById(R.id.sapxep);
        bt6=(Button)findViewById(R.id.daongaunhien);
        tv=(TextView)findViewById(R.id.textView2);
        nhapso=(EditText)findViewById(R.id.editText);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                String chuoi="";
                for(int i=0;i<myarr.length;i++)
                {
                    myarr[i]=r.nextInt(50-10+1)+10;
                    chuoi= chuoi+" "+myarr[i];

                }
                DocMangEditText();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DocMangEditText();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi="";
                for(int i=9;i>=0;i--)
                {
                    chuoi+=myarr[i]+" ";
                }
                tv.setText(chuoi);
            }
        });
    }
    public void DocMangEditText(){
        String chuoi="";
        for(int i=0;i<10;i++){
            chuoi+=myarr[i]+" ";
        }
        tv.setText(chuoi);
    }
}
