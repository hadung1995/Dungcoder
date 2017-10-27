package com.example.amd.huongdoituong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et1,et2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.editText) ;
        et2=(EditText)findViewById(R.id.editText2) ;
        tv=(TextView)findViewById(R.id.textView3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int c_dai=Integer.parseInt(et1.getText().toString());
                //int c_dai=Integer.parseInt(et1.getText().toString());
                //int c_rong=Integer.parseInt(et2.getText().toString());
                //int c_dai=Integer.parseInt(et1.getText().toString());
                //int c_rong=Integer.parseInt(et2.getText().toString());

                //HinhChuNhat a=new HinhChuNhat(c_dai,c_rong);
                int c_dai=Integer.parseInt(et1.getText().toString());
                int c_rong=Integer.parseInt(et2.getText().toString());
                HinhChuNhat a=new HinhChuNhat(c_dai,c_rong);
                String thong=a.getInfo();
                tv.setText(thong);
            }
        });

    }
}
