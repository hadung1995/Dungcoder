package com.example.amd.io;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt_clear,bt_write,bt_load,bt_docghi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et= (EditText) findViewById(R.id.editText);
        bt_clear= (Button) findViewById(R.id.button3);
        bt_write= (Button) findViewById(R.id.button2);
        bt_load= (Button) findViewById(R.id.button);
        bt_docghi=(Button)findViewById(R.id.button4);
        bt_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String chuoi=et.getText().toString();
                    FileOutputStream out=openFileOutput("dulieu.txt",MODE_PRIVATE);
                    byte[] buffer=chuoi.getBytes();
                    out.write(buffer);
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bt_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in=openFileInput("dulieu.txt");
                    byte[]buffer=new byte[in.available()];
                    in.read(buffer);
                    String chuoi=new String(buffer);
                    et.setText(chuoi);
                    in.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        bt_docghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
