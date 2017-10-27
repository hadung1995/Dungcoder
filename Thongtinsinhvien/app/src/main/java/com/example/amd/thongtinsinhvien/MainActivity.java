package com.example.amd.thongtinsinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> listsv=new ArrayList<Student>();

    EditText et1,et2;
    Button btn_them,btn_xoa,btn_sua;
    TextView tv,tv_sl;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);

        tv = (TextView) findViewById(R.id.textView3);
        tv_sl = (TextView) findViewById(R.id.textView_soluong);

        btn_them=(Button) findViewById(R.id.button1);
        btn_xoa=(Button) findViewById(R.id.button2);
        btn_sua=(Button) findViewById(R.id.button3);

        lv=(ListView) findViewById(R.id.listView1);
        Student.soluong=0;


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub

                Student sv_click= (Student) arg0.getItemAtPosition(arg2);
                et1.setText(sv_click.getStudent_id()+"");
                et2.setText(sv_click.getStudent_name());
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {
                    tv.setText("");

                    int id_sinhvien		=	Integer.parseInt(et1.getText().toString());
                    String ten_sinhvien	=	et2.getText().toString();

                    if(findStudentById(id_sinhvien, listsv) == null)
                    {
                        Student sv=new Student();
                        Student.soluong++;
                        sv.setStudent_id(id_sinhvien);
                        sv.setStudent_name(ten_sinhvien);

                        listsv.add(sv);
                    }
                    else
                        tv.setText("Mã số sinh viên đã tồn tại!!!");

                    showListView(listsv);
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    tv.setText(e.toString());
                }
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
    public void showListView(ArrayList<Student> listsv) {
        tv_sl.setText("Số lượng : "+Student.soluong);

        //Gán dữ liệu từ ArrayList vào ListView
        ArrayAdapter<Student> array_adt=new ArrayAdapter<Student>(getApplicationContext(), android.R.layout.simple_list_item_1 , listsv);

        lv.setAdapter(array_adt);
    }
    public Student findStudentById(int id, ArrayList<Student> list_student)
    {
        for (Student std : list_student) {
            if(std.getStudent_id()==id)
                return std;
        }
        return null;
    }
}