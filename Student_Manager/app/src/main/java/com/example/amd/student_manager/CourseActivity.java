package com.example.amd.student_manager;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {
    Database db=new Database(CourseActivity.this);
    SpinnerAdapter spinnerAdapter;
    CourseAdapter adapter;
    ListView lv;
     int course_id=0;
    ArrayList<Course> arrcouse=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        lv=(ListView)findViewById(R.id.lvcourse);
        dodulieu();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int c_id=0;
                Course c=arrcouse.get(i);
                c_id=c.id;
                Intent intent=new Intent(CourseActivity.this,ClassActivity.class);
                intent.putExtra("c_id",c_id);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.course_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_add){
            showdialog();
        }
        if(item.getItemId()==R.id.menu_student_add){
            showdialogclass();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showdialogclass() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.class_add);
        final EditText class_name=(EditText)dialog.findViewById(R.id.class_name);
        final EditText class_train=(EditText)dialog.findViewById(R.id.class_train);
        Spinner class_c_id=(Spinner)dialog.findViewById(R.id.spinner);
        final Button btn=(Button)dialog.findViewById(R.id.class_add_confirm) ;
        arrcouse=db.xemCourse();
        spinnerAdapter= new SpinnerAdapter(CourseActivity.this,arrcouse);
        class_c_id.setAdapter(spinnerAdapter);
        class_c_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              Course d = arrcouse.get(i);
                course_id=d.id;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id=course_id;
                        String name=class_name.getText().toString();
                        String train=class_train.getText().toString();
                        db.themclass(new Class(name,train,id));
                        Toast.makeText(CourseActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       dialog.show();
    }

    public void showdialog(){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.course_dialog_them);
        final EditText khoa=(EditText)dialog.findViewById(R.id.course_name);
        final EditText phone=(EditText)dialog.findViewById(R.id.course_phone);
        Button confirm=(Button)dialog.findViewById(R.id.course_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=khoa.getText().toString().trim();
                String b=phone.getText().toString().trim();
                db.themcourse(new Course(a,b));
                dodulieu();
                Toast.makeText(CourseActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void dodulieu(){
        arrcouse=db.xemCourse();
        adapter=new CourseAdapter(CourseActivity.this,arrcouse);
        lv.setAdapter(adapter);
    }
    public void suadialog(final Course c){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.course_dialog_sua);
        final EditText up_name=(EditText)dialog.findViewById(R.id.course_name_up);
        up_name.setText(c.name);
        final EditText up_phone=(EditText)dialog.findViewById(R.id.course_phone_up);
        up_phone.setText(c.phone);
        Button btn_up=(Button)dialog.findViewById(R.id.course_confirm_up);
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               c.name=up_name.getText().toString().trim();
                c.phone=up_phone.getText().toString().trim();
                db.suaCourse(c);
                dodulieu();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
