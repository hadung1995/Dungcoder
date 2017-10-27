package com.example.amd.viethoavietthuong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=et.getText().toString();
                String c=a.toLowerCase();

                char[] d= c.toCharArray();
                d[0]=Character.toUpperCase(d[0]);
                for(int i=1;i<d.length;i++)
                {
                    if(d[i]==' '){
                        d[i+1]=Character.toUpperCase(d[i+1]);
                    }
                }
            c= new String(d);
                tv.setText("Ket qua: "+c);
            }
        });
    }
}
