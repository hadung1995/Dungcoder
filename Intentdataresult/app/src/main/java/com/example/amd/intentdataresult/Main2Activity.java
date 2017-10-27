package com.example.amd.intentdataresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
EditText et;
Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et=(EditText)findViewById(R.id.editText);
        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten=et.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("tenmoine",ten);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
