package com.example.amd.ngay;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

                String a = et.getText().toString();
                tv.setText(""+a);
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
