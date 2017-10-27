package com.example.amd.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.io.OptionalDataException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    EditText et;
    ArrayList<DienThoai> arrdienthoai;
    DienthoaiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.list_view);
        et=(EditText) findViewById(R.id.inputSearch);
        arrdienthoai= new ArrayList<>();
        adapter = new DienthoaiAdapter(arrdienthoai,
        for (int i = 0; i < 100; i++) {
            Contacts contacts = new Contacts();
            contacts.setId(""+i);
            contacts.setName("Name "+i);
            _Contacts.add(contacts);
        }
        for(int i=1;i<products.length;i++){
            arrdienthoai.add(new DienThoai());
        }
        lv.setAdapter(adapter);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
