package com.example.amd.lamlaibaitest_android_sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Database database;
    ArrayList<CongViec> arraycongviec;
    CustomerAdapter adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcongviec);
        arraycongviec = new ArrayList<>();

        adapter=new CustomerAdapter(this,R.layout.dong_cong_viec,arraycongviec);
        lv.setAdapter(adapter);

        database = new Database(this,"ghinho.sqlite",null,1);

        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenViec Varchar(200) )");
        //database.Query("INSERT INTO CongViec VALUES(null,'Du lieu Andorid')");
        Getdatacongviec();
    }
    private void Getdatacongviec(){
        Cursor datacongviec = database.Getdata("SELECT * FROM CongViec");
        while(datacongviec.moveToNext()){
            String tencongviec=datacongviec.getString(1);
            int idcongviec= datacongviec.getInt(0);
            arraycongviec.add(new CongViec(idcongviec,tencongviec));
            Toast.makeText(this, tencongviec, Toast.LENGTH_SHORT).show();
        }
        adapter=new CustomerAdapter(this,R.layout.dong_cong_viec,arraycongviec);
        lv.setAdapter(adapter);
    }
}
