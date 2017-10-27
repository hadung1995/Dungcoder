package com.example.amd.giupbelamtoanchovui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText et1,et2,et3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        tv=(TextView)findViewById(R.id.textView5);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int max=10,min=0;
                int a=r.nextInt(max-min)+1;
                int b=r.nextInt(max-min)+1;
                et1.setText(String.valueOf(a));
                et2.setText(String.valueOf(b));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c=Integer.parseInt(et3.getText().toString());
                int a=Integer.parseInt(et1.getText().toString());
                int b=Integer.parseInt(et2.getText().toString());
                int tong=a+b;
                String chuoi;
                if(c==tong)
                {
                   chuoi="Be lam dung roi";
                }
                else
                {
                    chuoi="Be lam sai roi Ket qua la: "+tong;
                }
                tv.setText(chuoi);
            }
        });
    }
}
