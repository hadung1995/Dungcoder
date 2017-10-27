package com.example.amd.ontapchotatca;

import java.util.ArrayList;
import  java.util.Calendar;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Calendar lich=Calendar.getInstance();
    EditText et1, et2,et3;
    Button btn_them, btn_xoa, btn_sua,btn_nam;
    CheckBox cbandroid,cbphp,cbios;
    TextView tv, tv_sl;
    ListView lv;
    ArrayList<Student> studentlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btn_nam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyngaythang();
            }
        });
        Student.soluong=0;
        studentlist  = new ArrayList<Student>();
        //Thêm sinh viên
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(et1.getText().toString());
                String name=et2.getText().toString();
                String dob=et3.getText().toString();
                String monhoc="";
                if(findstudentbyid(id,studentlist)==null){
                    Student std = new Student();
                    Student.soluong++;
                    std.setStudent_id(id);
                    std.setStudent_name(name);
                    std.setStudent_dob(dob);
                    if(cbandroid.isChecked()){
                        monhoc+=cbandroid.getText();
                    }
                    if(cbios.isChecked()){
                        monhoc+=cbios.getText();
                    }
                    if(cbphp.isChecked()){
                        monhoc+=cbphp.getText();
                    }
                    std.setStudent_subject(monhoc);
                    studentlist.add(std);
                }
                else{
                    tv.setText("Sinh Viên đã tồn tại");
                }
                danhsach(studentlist);
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(et1.getText().toString());
                Student std = findstudentbyid(id,studentlist);
                if(std!=null){
                    studentlist.remove(std);
                    Student.soluong--;
                }
                danhsach(studentlist);
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(et1.getText().toString());
                String name=et2.getText().toString();
                String dob=et3.getText().toString();
                String monhoc="";
                Student sv = findstudentbyid(id,studentlist);
                if(sv!=null){
                    int index = studentlist.indexOf(sv);
                    sv.setStudent_name(name);
                    if(cbandroid.isChecked()){
                        monhoc+=cbandroid.getText();
                    }
                    if(cbios.isChecked()){
                        monhoc+=cbios.getText();
                    }
                    if(cbphp.isChecked()){
                        monhoc+=cbphp.getText();
                    }
                    sv.setStudent_subject(monhoc);
                    sv.setStudent_dob(dob);
                    studentlist.set(index,sv);

                }
                danhsach(studentlist);
            }
        });
    }
    private void AnhXa(){
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editTextdate);

        tv = (TextView) findViewById(R.id.textView3);
        tv_sl = (TextView) findViewById(R.id.textView_soluong);

        cbandroid=(CheckBox)findViewById(R.id.checkBox);
        cbphp=(CheckBox)findViewById(R.id.checkBox2);
        cbios=(CheckBox)findViewById(R.id.checkBox3);

        btn_them = (Button) findViewById(R.id.button1);
        btn_xoa = (Button) findViewById(R.id.button2);
        btn_sua = (Button) findViewById(R.id.button3);
        btn_nam=(Button) findViewById(R.id.btnyear);

        lv = (ListView) findViewById(R.id.listView1);

    }
    private void xulyngaythang(){
        DatePickerDialog datepicker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        et3.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },
                lich.get(Calendar.YEAR),
                lich.get(Calendar.MONTH),
                lich.get(Calendar.DAY_OF_MONTH));
        datepicker.show();
    }

    //Gán danh sách sinh viên cho list view
    public void danhsach(ArrayList<Student> students){
        tv_sl.setText("Số lượng: "+Student.soluong);
        ArrayAdapter arrdt = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,studentlist);
        lv.setAdapter(arrdt);
    }

    //Tìm sinh viên dựa trên id
    public Student findstudentbyid(int id,ArrayList<Student> find){
        for(Student std:find){
            if(std.getStudent_id()==id){
                return std;
            }
        }
        return null;
    }
}
