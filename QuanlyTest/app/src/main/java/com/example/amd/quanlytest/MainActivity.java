package com.example.amd.quanlytest;

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
    ArrayList<Student> list= new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        tv = (TextView) findViewById(R.id.textView3);
        tv_sl = (TextView) findViewById(R.id.textView_soluong);

        btn_them = (Button) findViewById(R.id.button1);
        btn_xoa = (Button) findViewById(R.id.button2);
        btn_sua = (Button) findViewById(R.id.button3);

        lv = (ListView) findViewById(R.id.listView1);
        Student.soluong=0;

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int masosinhvien=Integer.parseInt(et1.getText().toString());
                String tensinhvien=et2.getText().toString();
                if(findstudentbyid(masosinhvien,list)==null){
                    Student std =new Student();
                    std.soluong++;
                    std.setStudent_name(tensinhvien);
                    std.setStudent_id(masosinhvien);
                    list.add(std);
            }
            showdssv(list);
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso=Integer.parseInt(et1.getText().toString());
                String tensinhvien=et2.getText().toString();
                Student std = findstudentbyid(maso,list);
                if(std!=null){
                    int index=list.indexOf(std);
                    std.setStudent_name(tensinhvien);
                    list.set(index,std);
                    showdssv(list);
                }
            }
        });
    }
    public void showdssv(ArrayList<Student> dssv){
        tv_sl.setText("So luong : "+Student.soluong);

        ArrayAdapter arrdt=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,dssv);
        lv.setAdapter(arrdt);

    }
    public Student findstudentbyid(int id,ArrayList<Student> find){
        for(Student std : find){
            if(std.getStudent_id()==id){
                return std;
            }
        }
        return null;
    }
}
