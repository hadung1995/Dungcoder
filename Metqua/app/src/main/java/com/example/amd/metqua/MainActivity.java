package com.example.amd.metqua;

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
    ArrayList<Student> listsv = new ArrayList<Student>();

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

        Student.soluong = 0;

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(et1.getText().toString());
                String b=et2.getText().toString();
                if(findstudent(a,listsv)==null)
                {
                    Student sv = new Student();
                    sv.soluong++;
                    sv.setStudent_id(a);
                    sv.setStudent_name(b);
                    listsv.add(sv);
                }
                else
                {
                    tv.setText("Ma so sinh vien da ton tai");
                }
                showdssv(listsv);
            }
        });
    }

    public void showdssv(ArrayList<Student> listsv1) {
        tv_sl.setText("Số lượng: " + Student.soluong);

        ArrayAdapter<Student> array_adt = new ArrayAdapter<Student>(getApplicationContext(), android.R.layout.simple_list_item_1, listsv1);
        lv.setAdapter(array_adt);
    }

    public Student findstudent(int id, ArrayList<Student> list_student) {
        for (Student std : list_student) {
            if (std.getStudent_id() == id)
                return std;
        }

        return null;
    }
}
