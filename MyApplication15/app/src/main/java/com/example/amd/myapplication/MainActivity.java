package com.example.amd.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Database database;
    CustomAdapter adapter;
    ArrayList<Player> arrlist;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listview);
        arrlist = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this,arrlist);
        lv.setAdapter(adapter);
        database = new Database(MainActivity.this,"SearchView",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS Search(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenPlayer VARCHAR(200))");
        database.Query("INSERT INTO Search VALUES(null,'EdenHazard')");
        getdata();
    }
    private void getdata(){
        Cursor getdatacongviec=database.Getdata("SELECT * FROM Search");

        while(getdatacongviec.moveToNext()){
            String ten=getdatacongviec.getString(1);
            int id=getdatacongviec.getInt(0);
            arrlist.add(new Player(id,ten));

        }
        adapter.notifyDataSetChanged();
    }
}
