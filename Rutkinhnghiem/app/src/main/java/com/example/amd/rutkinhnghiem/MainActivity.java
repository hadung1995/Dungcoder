package com.example.amd.rutkinhnghiem;

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
    ArrayList<student> dssv = new ArrayList<student>();
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

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(et1.getText().toString());
                String b=et2.getText().toString();
                if(findstudentbyid(a,dssv)==null){
                    student sthem=new student();
                    student.soluong++;
                    sthem.setStudent_name(b);
                    sthem.setStudent_id(a);
                    dssv.add(sthem);
                }
                else{
                    tv.setText("Id da ton tai");
                }
                showviewlist(dssv);
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_sinhvien=Integer.parseInt(et1.getText().toString());
                student sv = findstudentbyid(id_sinhvien,dssv);
                if(sv!=null){
                    dssv.remove(sv);
                    student.soluong--;
                }
                showviewlist(dssv);
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_sinhvien=Integer.parseInt(et1.getText().toString());
                String b=et2.getText().toString();
                student sv = findstudentbyid(id_sinhvien,dssv);
                if(sv!=null){
                    int index=dssv.indexOf(sv);
                    sv.setStudent_name(b);
                    dssv.set(index,sv);
                    showviewlist(dssv);
                }
            }
        });
    }
    public void showviewlist(ArrayList<student>list){
        tv_sl.setText("so luong: "+student.soluong);

        ArrayAdapter<student> arrdt=new ArrayAdapter<student>(getApplicationContext(),android.R.layout.simple_list_item_1,dssv);
        lv.setAdapter(arrdt);
    }
    public student findstudentbyid(int id,ArrayList<student>list1){
        for(student std: list1){
            if(std.getStudent_id()==id){
                return std;
            }
        }
        return null;
    }
}
