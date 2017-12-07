package com.example.amd.assignmenmap;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {
    EditText et_user,et_name,et_dob,et_pass;
    ImageButton img;
    Button btn;
    Database db;
    Calendar lich= Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn=(Button)findViewById(R.id.button);
        img=(ImageButton)findViewById(R.id.imageButton);
        et_user=(EditText)findViewById(R.id.editText);
        et_pass=(EditText)findViewById(R.id.editText2);
        et_name=(EditText)findViewById(R.id.editText3);
        et_dob=(EditText)findViewById(R.id.editText6);
        db=new Database(SignUpActivity.this);
        try {
            db.createDataBase();
            db.close();
            db.openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyngaythangnam();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=et_user.getText().toString();
                String pass=et_pass.getText().toString();
                String name=et_name.getText().toString();
                String dob=et_dob.getText().toString();
                db.themuser(new User(id,pass,name,dob));
                Toast.makeText(SignUpActivity.this, "Dang Ky Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void xulyngaythangnam() {
        DatePickerDialog datepicker=new DatePickerDialog(
                SignUpActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        et_dob.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },
                lich.get(Calendar.YEAR),
                lich.get(Calendar.MONTH),
                lich.get(Calendar.DAY_OF_MONTH)
        );
        datepicker.show();
    }
}
