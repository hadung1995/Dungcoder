package com.example.amd.quanlysinhvien;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar lich=Calendar.getInstance();
    EditText et1, et2,et3;
    Button btn_them, btn_xoa, btn_sua,btn_year;
    CheckBox cbandroid,cbphp,cbios;
    TextView tv, tv_sl;
    ListView lv;
    ArrayList<Student> listsv = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editTextdate);

        tv = (TextView) findViewById(R.id.textView3);
        tv_sl = (TextView) findViewById(R.id.textView_soluong);

        cbandroid=(CheckBox)findViewById(R.id.checkBox);
        cbphp=(CheckBox)findViewById(R.id.checkBox2);
        cbios=(CheckBox)findViewById(R.id.checkBox3);

        btn_them = (Button) findViewById(R.id.button1);
        btn_xoa = (Button) findViewById(R.id.button2);
        btn_sua = (Button) findViewById(R.id.button3);
        btn_year=(Button)findViewById(R.id.button4);

        lv = (ListView) findViewById(R.id.listView1);

        btn_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyngaythang();
            }
        });

        Student.soluong = 0;

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(et1.getText().toString());
                String b=et2.getText().toString();
                String year=et3.getText().toString();
                String monhoc1="";
                if(findstudent(a,listsv)==null)
                {
                    Student sv = new Student();
                    sv.soluong++;
                    sv.setStudent_id(a);
                    sv.setStudent_name(b);
                    sv.setDob(year);
                    if(cbandroid.isChecked()){
                        monhoc1+=cbandroid.getText();
                    }
                    sv.setMon_hoc(monhoc1);
                    listsv.add(sv);
                }
                else
                {
                    tv.setText("Ma so sinh vien da ton tai");
                }
                showdssv(listsv);
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("");
                int id=Integer.parseInt(et1.getText().toString());
                Student sv = findstudent(id,listsv);
                if(sv!=null){
                    listsv.remove(sv);
                    Student.soluong--;
                }
            }
        });
        cbandroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this,"Bạn đã chon android",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Bạn bỏ android",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void showdssv(ArrayList<Student> listsv1) {
        tv_sl.setText("Số lượng: " + Student.soluong);

        ArrayAdapter<Student> array_adt = new ArrayAdapter<Student>(getApplicationContext(), android.R.layout.simple_list_item_1, listsv1);
        lv.setAdapter(array_adt);
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

    public Student findstudent(int id, ArrayList<Student> list_student) {
        for (Student std : list_student) {
            if (std.getStudent_id() == id)
                return std;
        }

        return null;
    }
}

