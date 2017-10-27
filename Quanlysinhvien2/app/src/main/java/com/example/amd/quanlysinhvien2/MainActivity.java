package com.example.amd.quanlysinhvien2;

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
    ArrayList<Student> listsv = new ArrayList<Student>();
    EditText et1, et2;
    Button btn_them,btn_sua,btn_xoa;
    TextView tv, tv_sl;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);

        tv = (TextView) findViewById(R.id.textView3);
        tv_sl = (TextView) findViewById(R.id.textView_soluong);

        btn_them = (Button) findViewById(R.id.button1);


        lv = (ListView) findViewById(R.id.listView1);
        Student.soluong=0;

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(et1.getText().toString());
                String b= et2.getText().toString();
                if(findstudent(a,listsv)==null){
                    Student st=new Student();
                    Student.soluong++;
                    st.setStudent_id(a);
                    st.setStudent_name(b);
                    listsv.add(st);
                }
                else
                    {
                        tv.setText("Id da ton tai");
                    }
                showdssv(listsv);
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {
                    tv.setText("");
                    int id_sinhvien		=	Integer.parseInt(et1.getText().toString());

                    Student sv 	= findStudentById(id_sinhvien, listsv);

                    if(sv != null)
                    {
                        listsv.remove(sv);
                        Student.soluong--;
                    }


                    showListView(listsv);
                } catch (NumberFormatException e) {
                    // TODO: handle exception
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

                    int id_sinhvien		=	Integer.parseInt(et1.getText().toString());
                    String ten_sinhvien	=	et2.getText().toString();

                    Student sv 	= findStudentById(id_sinhvien, listsv);

                    if(sv != null)
                    {
                        int index = listsv.indexOf(sv);
                        sv.setStudent_name(ten_sinhvien);

                        listsv.set(index, sv);

                        showListView(listsv);
                    }
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    tv.setText(e.toString());
                }
            }
        });
    }
    //show danh sach sinh vien
    public void showdssv(ArrayList<Student> listsv) {
        tv_sl.setText("Số lượng: " + Student.soluong);

        ArrayAdapter<Student> array_adt = new ArrayAdapter<Student>(getApplicationContext(), android.R.layout.simple_list_item_1, listsv);
        lv.setAdapter(array_adt);
    }

    public Student findstudent(int id, ArrayList<Student> listsv) {
        for (Student std : listsv) {
            if (std.getStudent_id() == id)
                return std;
        }

        return null;
    }
}
