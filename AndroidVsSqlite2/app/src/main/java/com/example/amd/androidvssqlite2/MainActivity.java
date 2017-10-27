package com.example.amd.androidvssqlite2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ArrayList<CongViec> arraylist;
    MenuAdapter adapter;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcongviec);
        arraylist = new ArrayList<>();
        adapter = new MenuAdapter(this,R.layout.dong_cong_viec,arraylist);
        lv.setAdapter(adapter);

        database = new Database(this,"ghichu123.sqlite",null,1);

        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id Integer PRIMARY KEY AUTOINCREMENT,TenCV varchar(200)) ");

       // database.Query("INSERT INTO CongViec VALUES(null,'Bai Tap Android')");

        GetDataCongViec();
    }
    private void GetDataCongViec(){

        Cursor datacongviec = database.Getdata("SELECT * FROM CongViec");
        while(datacongviec.moveToNext()){
            String ten = datacongviec.getString(1);
            int id =datacongviec.getInt(0);
            arraylist.add(new CongViec(id,ten));

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ad_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
