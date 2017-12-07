package com.example.amd.student_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText username,pass;
    Button btn;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.pass);
        btn=(Button)findViewById(R.id.button);
        db=new Database(MainActivity.this);
        try {
            db.createDataBase();
            db.close();
            db.openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString().trim();
                String pas=pass.getText().toString().trim();
                String confirm=db.login(user);
                if(pas.equals(confirm)){
                    Intent intent=new Intent(MainActivity.this,CourseActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
