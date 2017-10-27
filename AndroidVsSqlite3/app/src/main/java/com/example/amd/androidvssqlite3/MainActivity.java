package com.example.amd.androidvssqlite3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    CustomAdaptor adapter;
    ArrayList<CongViec> arrcongviec;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcongviec);

        arrcongviec= new ArrayList<>();

        adapter=new CustomAdaptor(this,R.layout.dong_cong_viec,arrcongviec);
        lv.setAdapter(adapter);

        database = new Database(this,"ghichu456",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV varchar(200))");
        //database.Query("INSERT INTO CongViec VALUES(null,'Luu bai tap ')");
        Getdatacv();

    }
    private void Getdatacv(){
        Cursor datacongviec=database.Getdata("SELECT * FROM CongViec");
        arrcongviec.clear();
        while(datacongviec.moveToNext()){
            int id=datacongviec.getInt(0);
            String ten=datacongviec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
            arrcongviec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dialogthem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuadd){
            Dialogthem();
        }
        return super.onOptionsItemSelected(item);
    }
    private void Dialogthem(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.them_cong_viec);
       final EditText edten=dialog.findViewById(R.id.editthem);
        Button  btnconfirm=dialog.findViewById(R.id.btnconfirm);
        Button  btnabort=dialog.findViewById(R.id.btnabort);
        btnabort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tencvm=edten.getText().toString();
                if(tencvm.equals("")){
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu vào dùm", Toast.LENGTH_SHORT).show();
                }
                else{
                    database.Query("INSERT INTO CongViec VALUES(null,'"+tencvm+" ')");
                    dialog.dismiss();
                    Getdatacv();
                }
            }
        });

        dialog.show();
    }
    public void Dialogxoa(final int id, String tencv){
        AlertDialog.Builder dialogxoa = new AlertDialog.Builder(this);
        dialogxoa.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.Query("DELETE FROM CongViec WHERE Id ='"+id+"'");
                Getdatacv();
            }
        });
        dialogxoa.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogxoa.show();
    }
    
    public void Dialogsua(final int id,String ten){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua_cong_viec);
        final EditText edten=dialog.findViewById(R.id.editthem);
        Button  btnconfirm=dialog.findViewById(R.id.btnconfirm);
        Button  btnabort=dialog.findViewById(R.id.btnabort);
        edten.setText(ten);
        btnabort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenmoi=edten.getText().toString();
                database.Query("UPDATE CongViec SET TenCV='"+tenmoi+"' WHERE Id='"+id+"' ");
                Toast.makeText(MainActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Getdatacv();
            }
        });
        dialog.show();

}}
