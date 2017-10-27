package com.example.amd.nhatnghe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    Button btn;
    TextView tv1,tv2;
    String []ds=new String[]{"cam","xoai","coc","oi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1= (Spinner) findViewById(R.id.spinner);
        sp2= (Spinner) findViewById(R.id.spinner2);
        btn=(Button)findViewById(R.id.button);
        tv1= (TextView) findViewById(R.id.textView);
        tv2= (TextView) findViewById(R.id.textView2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,ds);
        arrayAdapter.setDropDownViewResource(R.layout.one_item);
        sp2.setAdapter(arrayAdapter);


        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //chon ngay tren spiner
//                tv1.setText(ds[position]);
                tv1.setText(sp2.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(sp2.getSelectedItem().toString());
            }
        });
    }

}
