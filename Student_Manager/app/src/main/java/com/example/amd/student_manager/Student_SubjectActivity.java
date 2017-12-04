package com.example.amd.student_manager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Student_SubjectActivity extends AppCompatActivity {
    Calendar lich=Calendar.getInstance();
    int class_id;
    int course_id;
    ViewPager viewpager;
    StudentAdapter adapter1;
    ArrayList<Student> arrayList1=new ArrayList<>();
//    TabLayout tablayout;
    ImageView iv,iv1;
    FragmentAdapter adapter;
    String[] title = {"Học Sinh", "Môn Học"};
    Database db=new Database(Student_SubjectActivity.this);
    ArrayList<Class> arrayList=new ArrayList<>();
    SpinnerClassAdapter spinneradapter;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__subject);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
//        tablayout = (TabLayout) findViewById(R.id.sliding_tabs);
        btn=(Button)findViewById(R.id.button2);
        class_id=getIntent().getExtras().getInt("class_id");
        course_id=getIntent().getExtras().getInt("course_id");
        adapter= new FragmentAdapter(getSupportFragmentManager(),Student_SubjectActivity.this,class_id,course_id);
        viewpager.setAdapter(adapter);
//        tablayout.setupWithViewPager(viewpager);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdialogstudent();
            }
        });
//        class_id=getIntent().getExtras().getInt("class_id");
    }


    private void showdialogstudent() {
            Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.student_add);
            final EditText etdob=(EditText)dialog.findViewById(R.id.student_dob);
            Button b=(Button)dialog.findViewById(R.id.button113);
            Spinner spinner=(Spinner)dialog.findViewById(R.id.spinner_student_add);
            final EditText et_name=(EditText)dialog.findViewById(R.id.student_name);
            final EditText et_dob=(EditText)dialog.findViewById(R.id.student_dob);
            iv=(ImageView)dialog.findViewById(R.id.imageView4);
            final Button btn=(Button)dialog.findViewById(R.id.student_confirm);
            final CheckBox cbmale=(CheckBox)dialog.findViewById(R.id.checkBox);
            final CheckBox cbfemale=(CheckBox)dialog.findViewById(R.id.checkBox2);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pick=new Intent(Intent.ACTION_GET_CONTENT);
                    pick.setType("image/*");
                    Intent pho=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Intent chosser=Intent.createChooser(pick, "chon");
                    chosser.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pho});
                    startActivityForResult(chosser, 999);
                }
            });
            b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyngaythangnam(etdob);
            }
        });
            arrayList=db.xemclass(course_id);
            spinneradapter=new SpinnerClassAdapter(Student_SubjectActivity.this,arrayList);
            spinner.setAdapter(spinneradapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Class cl=arrayList.get(i);
                    class_id=cl.id;
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id=class_id;
                            String name=et_name.getText().toString();
                            String dob=et_dob.getText().toString();
                            //sex
                            String sex="";
                            if(cbmale.isChecked()){
                                sex+=cbmale.getText();
                            }
                            if(cbfemale.isChecked()){
                                sex+=cbfemale.getText();
                            }
                            BitmapDrawable bitmapDrawable= (BitmapDrawable) iv.getDrawable();
                            Bitmap bitmap=bitmapDrawable.getBitmap();
                            ByteArrayOutputStream byteArrays = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrays);
                            byte[] hinhanh=byteArrays.toByteArray();
                            db.themstudent(new Student(name,dob,sex,id,hinhanh));
                            Toast.makeText(Student_SubjectActivity.this, "Thêm thành công đề nghĩ kiểm tra database ", Toast.LENGTH_SHORT).show();
                            //
                        }
                    });
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            dialog.show();
//            onActivityResult(requestcode,RESULT_OK,getIntent(),img_hinh);
    }
    public void xulyngaythangnam(final EditText et) {
        DatePickerDialog datepicker=new DatePickerDialog(
                Student_SubjectActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        et.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },
                lich.get(Calendar.YEAR),
                lich.get(Calendar.MONTH),
                lich.get(Calendar.DAY_OF_MONTH)
        );
        datepicker.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==999&&resultCode==RESULT_OK&&data!=null){
            if(data.getExtras()!=null)
            {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                iv.setImageBitmap(imageBitmap);
            }
            else{
                Uri uri=data.getData();
                iv.setImageURI(uri);
            }



        }
        if(requestCode==777&&resultCode==RESULT_OK&&data!=null){
            if(data.getExtras()!=null)
            {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                iv1.setImageBitmap(imageBitmap);
            }
            else{
                Uri uri=data.getData();
                iv1.setImageURI(uri);
            }



        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void student_dialog(final Student std){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.student_update);
        iv1=(ImageView)dialog.findViewById(R.id.imageView456);
        final CheckBox cbmale=(CheckBox)dialog.findViewById(R.id.checkBox_up);
        final CheckBox cbfemale=(CheckBox)dialog.findViewById(R.id.checkBox2_up);
        final EditText etname=(EditText)dialog.findViewById(R.id.student_name_up);
        final EditText etdob=(EditText)dialog.findViewById(R.id.student_dob_up);
        Button btn_dob=(Button)dialog.findViewById(R.id.button1134);
        final Button btn_confirm=(Button)dialog.findViewById(R.id.student_confirm_up);
        Spinner spinner=(Spinner)dialog.findViewById(R.id.spinner_student_up);
        etname.setText(std.name);
        etdob.setText(std.dob);
        String sex=std.sex;
        Toast.makeText(this, sex, Toast.LENGTH_SHORT).show();
        cbmale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbfemale.setChecked(false);
                }
            }
        });
        cbfemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbmale.setChecked(false);
                }
            }
        });
        if(sex.equals(cbmale.getText().toString())){
            cbmale.setChecked(true);
        }
        if(sex.equals(cbfemale.getText().toString())){
            cbfemale.setChecked(true);
        }
        byte[] hinhanh = std.picture;
        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        iv1.setImageBitmap(bitmap);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pick=new Intent(Intent.ACTION_GET_CONTENT);
                pick.setType("image/*");
                Intent pho=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent chosser=Intent.createChooser(pick, "chon");
                chosser.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pho});
                startActivityForResult(chosser, 777);
            }
        });
        btn_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyngaythangnam(etdob);
            }
        });
        arrayList=db.xemclass(course_id);
        spinneradapter=new SpinnerClassAdapter(Student_SubjectActivity.this,arrayList);
        spinner.setAdapter(spinneradapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Class cl=arrayList.get(i);
                class_id=cl.id;
                btn_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id=class_id;
                        //class
                        std.class_id=id;
                        //sex
                        String sex="";
                        if(cbmale.isChecked()){
                            sex+=cbmale.getText();
                        }
                        if(cbfemale.isChecked()){
                            sex+=cbfemale.getText();
                        }
                        std.sex=sex;
                        //

                        //name
                        std.name=etname.getText().toString();
                        //name

                        //dob
                        std.dob=etdob.getText().toString();
                        //dob

                        //hinhanh
                        BitmapDrawable bitmapDrawable= (BitmapDrawable) iv1.getDrawable();
                        Bitmap bitmap=bitmapDrawable.getBitmap();
                        ByteArrayOutputStream byteArrays = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrays);
                        byte[] hinhanh=byteArrays.toByteArray();
                        std.picture=hinhanh;
                        //
                        db.suaStudent(std);
                        Toast.makeText(Student_SubjectActivity.this, "Sua thanh cong", Toast.LENGTH_SHORT).show();
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
