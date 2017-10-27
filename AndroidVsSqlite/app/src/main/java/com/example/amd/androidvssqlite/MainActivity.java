package com.example.amd.androidvssqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ArrayList<CongViec> arrcongviec;
    MenuAdapter adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcongviec);
        adapter = new MenuAdapter(this,R.layout.dong_cong_viec,arrcongviec);
        lv.setAdapter(adapter);
        arrcongviec = new ArrayList<>();

        database = new Database(this,"ghichu.sqlite",null,1);

        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id Integer PRIMARY KEY AUTOINCREMENT,TenCV varchar(200)) ");

        //database.Query("INSERT INTO CongViec VALUES(null,'Bai Tap Android')");

        Cursor datacongviec=database.Getdata("SELECT * FROM CongViec");
        while(datacongviec.moveToNext()){
            String ten=datacongviec.getString(1);
            int id=datacongviec.getInt(0);
            arrcongviec.add(new CongViec(id,ten));
            Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();

        }
        adapter = new MenuAdapter(this,R.layout.dong_cong_viec,arrcongviec);
        lv.setAdapter(adapter);
    }
}
