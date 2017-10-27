package com.example.amd.thanhdungsample2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListView;
    private CustomAdapter mCustomAdapter;
    private EditText mEditText;
    private ArrayList<Contacts> _Contacts = new ArrayList<Contacts>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        for (int i = 0; i < 100; i++) {
            Contacts contacts = new Contacts();
            contacts.setId(""+i);
            contacts.setName("Name "+i);
            _Contacts.add(contacts);
        }



        mListView = (ListView) findViewById(R.id.listView1);
        mEditText = (EditText) findViewById(R.id.editText1);

        mCustomAdapter = new CustomAdapter(MainActivity.this, _Contacts);
        mListView.setAdapter(mCustomAdapter);

        mEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                mCustomAdapter.getFilter().filter(arg0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }


        });
    }

}
