package com.example.amd.thaotacvoimangsonguyen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        //tao random
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r =new Random();
                for(int i=0;i<10;i++)
                {
                    myarr[i]=r.nextInt(50-10+1)+10;
                }
                chayramang();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chayramang();
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
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int max=myarr[0];
                int min=myarr[0];
                for(int i=0;i<10;i++)
                {
                    if(myarr[i]<min)
                    {
                        min=myarr[i];
                    }
                   if(myarr[i]>max)
                    {
                        max=myarr[i];
                    }

                }

                nhapso.setText("Min: "+min+"And max: "+max);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi="";
                for(int i=0;i<myarr.length-1;i++)
                {
                    int temp=myarr[i];
                    for(int j=i+1;j<myarr.length;j++)
                    {
                        if(temp>myarr[j])
                        {
                            myarr[i]=myarr[j];
                            myarr[j]=temp;
                            temp=myarr[i];
                        }
                    }
                }
                    for(int i=0;i<10;i++)
                    {
                        chuoi+=myarr[i]+" ";
                    }
                nhapso.setText(chuoi);

            }
        });
    }

    public void chayramang()
    {
        String chuoi="";
        for(int i=0;i<10;i++)
        {
            chuoi+=myarr[i]+" ";
        }
        tv.setText(chuoi);
    }
}
