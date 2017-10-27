package com.example.amd.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etuser,etpass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=etuser.getText().toString();
                String pass=etpass.getText().toString();
                if(id.equals("admin") & pass.equals("admin")){
                    Intent intent = new Intent(MainActivity.this,Secondactivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa(){
        etuser=(EditText)findViewById(R.id.editText);
        etpass=(EditText)findViewById(R.id.editText2);
        btnlogin=(Button)findViewById(R.id.btnlogin);
    }
}
