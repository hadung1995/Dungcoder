package com.example.amd.myapplication;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity {
    Calendar lich=Calendar.getInstance();
    Button btn,btn1;
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn1=(Button)findViewById(R.id.button2);
        et=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyngaythang();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.applyPattern("dd/MM/YYYY");
                String a = et.getText().toString();
                try {
                    Date b = sdf.parse(a);
                    long c=(b.getTime())/24/60/60/1000;
                    tv.setText(c+" ngay");
                }
                catch(Exception e){
                    tv.setText("Co tinh lam sai chuong trinh bam nut Next");
                }
            }
        });
    }
    private void xulyngaythang()
    {
        DatePickerDialog datepicker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        et.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },
                lich.get(Calendar.YEAR),
                lich.get(Calendar.MONTH),
                lich.get(Calendar.DAY_OF_MONTH));
        datepicker.show();
    }

}
