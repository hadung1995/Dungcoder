package com.example.amd.array2chieutest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int arr[][]={{1,2,3},{2,4,5},{4,4,5}};
                String chuoi="";
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                       chuoi+=(arr[i][j]+" ");
                    }
                }
                tv.setText("chuoi: "+chuoi);
            }
        });
    }
}
