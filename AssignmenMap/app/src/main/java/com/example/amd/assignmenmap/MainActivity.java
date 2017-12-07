package com.example.amd.assignmenmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Database db;
    EditText etusername, etpassword;
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusername = (EditText) findViewById(R.id.editText4);
        etpassword = (EditText) findViewById(R.id.editText5);
        btn = (Button) findViewById(R.id.button3);
        btn2=(Button)findViewById(R.id.button2);
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

                String username = etusername.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                String storepass = db.checkuser(username);
                if (username.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Nhap thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(storepass)) {
                       Intent intent=new Intent(MainActivity.this,PlaceActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
