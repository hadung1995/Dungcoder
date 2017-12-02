package com.example.amd.student_manager;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassActivity extends AppCompatActivity {
   Database db=new Database(ClassActivity.this);
    ArrayList<Course> arrcourse=new ArrayList<>();
    SpinnerAdapter spinneradapter;
    int  course;
    ClassAdapter adapter;
    ArrayList<Class> arrclass=new ArrayList<>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        lv=(ListView)findViewById(R.id.lv_class);
        course=getIntent().getExtras().getInt("c_id");
        dodulieu();
    }
    public void dodulieu(){
        arrclass=db.xemclass(course);
        adapter=new ClassAdapter(this,arrclass);
        lv.setAdapter(adapter);
    }
    public void dialogsua(final Class cl){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.class_update);
        final EditText class_name=(EditText)dialog.findViewById(R.id.class_name_up);
        class_name.setText(cl.name);
        final EditText class_train=(EditText)dialog.findViewById(R.id.class_train_up);
        class_train.setText(cl.train);
        Spinner class_c_id=(Spinner)dialog.findViewById(R.id.spinner_up);
        final Button btn=(Button)dialog.findViewById(R.id.class_confirm_up) ;
        arrcourse=db.xemCourse();
        spinneradapter= new SpinnerAdapter(ClassActivity.this,arrcourse);
        class_c_id.setAdapter(spinneradapter);
        class_c_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Course d = arrcourse.get(i);
                course=d.id;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id=course;
                        cl.name=class_name.getText().toString();
                        cl.train=class_train.getText().toString();
                        cl.course_id=course;
                        db.suaClass(cl);
                        dodulieu();
                        dialog.dismiss();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dialog.show();
    }
}
