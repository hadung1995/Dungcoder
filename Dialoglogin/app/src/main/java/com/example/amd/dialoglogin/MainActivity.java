package com.example.amd.dialoglogin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    View view;
    EditText et1, et2;
    String admin = "admin";
    String mes="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienthidialog();
            }
        });
    }

    // OK chưa bạn cho mình hỏi tại sao lại phải equal mà không phải là == bro?
    // Cái hàm equal đó tương tự == thôi.
    //Giờ sửa lại == cũng chạy. Chắc thế. đéo gì thế?
    //Thế bạn cứ để là equal đi vậy. ừ tks bro

    public void hienthidialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflat1 = this.getLayoutInflater();

        view = (inflat1.inflate(R.layout.login, null));
        alert.setView(view);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                et1 = (EditText) view.findViewById(R.id.editText3);
                et2 = (EditText) view.findViewById(R.id.editText4);
                String a = et1.getText().toString();
                String b = et2.getText().toString();



                //Hình như là && được hiểu là cái này và cái kia là nó trả về true r.
                //Còn & là yêu cần 2 cái đúng nó mới trả về true


                    if ((a.equals(admin)) & (b.equals(admin))) {
                        mes="nhập tài khoản thành công";
                    } else {
//                    Toast.makeText(MainActivity.this, "Dang Nhap That Bai", Toast.LENGTH_SHORT).show();
                        hienthidialog();
                    }

                Toast.makeText(MainActivity.this, mes, Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }
}
