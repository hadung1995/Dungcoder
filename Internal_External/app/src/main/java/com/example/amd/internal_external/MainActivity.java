package com.example.amd.internal_external;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button bt_clear,bt_write,bt_load;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_clear= (Button) findViewById(R.id.button);
        bt_write= (Button) findViewById(R.id.button2);
        bt_load= (Button) findViewById(R.id.button3);
        et= (EditText) findViewById(R.id.editText);

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
            }
        });
        bt_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });
        bt_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
    }
    public void write()
    {
        try {
///internal storage , data/data/tenpackage/files/
//            FileOutputStream out=openFileOutput("abc.txt",MODE_APPEND);
/////////////////////////////////////////////////////////////////

//internal storage, thu muc cache
            File duongdan=getCacheDir();
            File taptin=new File(duongdan,"cache.txt");
            FileOutputStream out=new FileOutputStream(taptin);
//////////////////////////////////////////////////////////////////

//extenal storage, mnt/sdcard
            /*File duongdan= Environment.getExternalStorageDirectory();
            File taptin=new File(duongdan,"xyz.txt");
            FileOutputStream out=new FileOutputStream(taptin);*/
/////////////////////////////////////////////////////////////////

//extenal storage, kieu dung dung dan va tao thu muc con, mnt/sdcard
            //neu dung the nho ngoai(the nho nho go ra gan vo pc) thi duongdan="mnt/extsdcard" (co them chu ext)
            /*String duongdan="/mnt/sdcard/"; //Environment.getExternalStorageDirectory().toString();
            File file=new File(duongdan,"/mot/hai/ba/bon");
            file.mkdirs();
            File taptin =new File(file,"bbb.txt");
            FileOutputStream out=new FileOutputStream(taptin);*/
/////////////////////////////////////////////////////////////////


//extenal storage public directory, mnt/sdcard/thumucpublic
            /*File duongdan= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File taptin=new File(duongdan,"aaa.txt");
            FileOutputStream out=new FileOutputStream(taptin);*/
/////////////////////////////////////////////////////////////////


            String chuoi=et.getText().toString();
            out.write(chuoi.getBytes());
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void load()
    {
        try {
//internal storage,
            //FileInputStream in=openFileInput("abc.txt");
/////////////////////////////////////////////////////////////////

//internal storage, cache
            File duongdan=getCacheDir();
            File taptin=new File(duongdan,"cache.txt");
            FileInputStream in=new FileInputStream(taptin);

//external storage, mnt/sdcard
            /*File duongdan=Environment.getExternalStorageDirectory();
            File taptin=new File(duongdan,"xyz.txt");
            FileInputStream in=new FileInputStream(taptin);*/
////////////////////////////////////////////////////////////////

//external storage doc thu muc con, mnt/sdcard
            /*File duongdan=Environment.getExternalStorageDirectory();
            File taptin=new File(duongdan+"/mot/hai/ba/bon","bbb.txt");
            FileInputStream in=new FileInputStream(taptin);*/
////////////////////////////////////////////////////////////////

//external storage public directory, mnt/sdcard/thumucpublic
            /*File duongdan=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File taptin=new File(duongdan,"aaa.txt");
            FileInputStream in=new FileInputStream(taptin);*/
////////////////////////////////////////////////////////////////

            byte[] buffer=new byte[in.available()];
            in.read(buffer);
            et.setText(new String(buffer));
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
