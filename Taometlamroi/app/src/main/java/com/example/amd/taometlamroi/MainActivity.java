package com.example.amd.taometlamroi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btn_them, btn_xoa, btn_sua;
    TextView tv, tv_sl;
    ListView lv;
    ArrayList<student> listv=new ArrayList<student>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        tv = (TextView) findViewById(R.id.textView3);
        tv_sl = (TextView) findViewById(R.id.textView_soluong);

        btn_them = (Button) findViewById(R.id.button1);
        btn_xoa = (Button)findViewById(R.id.button2);
        lv = (ListView) findViewById(R.id.listView1);

        student.soluong=0;

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mssv=Integer.parseInt(et1.getText().toString());
                String tsv=et2.getText().toString();
                if(findStudentById(mssv,listv)==null){
                    student s = new student();
                    s.soluong++;
                    s.setStudent_id(mssv);
                    s.setStudent_name(tsv);
                    listv.add(s);

                }
                else
                {
                    tv.setText("mssv da ton tai");
                }
                showListView(listv);
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int mssv=Integer.parseInt(et1.getText().toString());
                    student std=findStudentById(mssv,listv);
                    if(std!=null){
                        listv.remove(std);
                        student.soluong--;
                    }
                    showListView(listv);
                }
                catch(Exception e){
                    tv.setText(e.toString());
                }
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {
                    tv.setText("");

                    int id_sinhvien = Integer.parseInt(et1.getText().toString());
                    String ten_sinhvien = et2.getText().toString();

                    student sv = findStudentById(id_sinhvien, listv);

                    if (sv != null) {
                        int index = listv.indexOf(sv);
                        sv.setStudent_name(ten_sinhvien);

                        listv.set(index, sv);

                        showListView(listv);
                    }
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    tv.setText(e.toString());
                }
            }
        });
    }

    //dua arraylist vao listview bang arrayadapter
    public void showListView(ArrayList<student> list)
    {
        tv_sl.setText("So luong: "+student.soluong);
        ArrayAdapter arrdt = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(arrdt);
    }
    //kiem tra thong tin thong qua id va duyet mang
    public student findStudentById(int id,ArrayList<student> ktsv){
        for(student std:ktsv)
        {
            if(std.getStudent_id()==id){
                return std;
            }
        }
        return null;
    }
}
