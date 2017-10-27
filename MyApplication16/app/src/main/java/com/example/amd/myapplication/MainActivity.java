package com.example.amd.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ArrayList<CongViec> arrlist;
    ListView lv;
    SearchView sv;
    CustomerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        sv=(SearchView)findViewById(R.id.searchview);
        arrlist = new ArrayList<>();
        database = new Database(this,"ghichu456",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV varchar(200))");
        //database.Query("INSERT INTO CongViec VALUES(null,'Luu Bai Tap 4')");
        getdata();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
    private void getdata(){
        Cursor getdatacv=database.Getdata("SELECT * FROM CongViec");
        while(getdatacv.moveToNext()){
            int id=getdatacv.getInt(0);
            String ten=getdatacv.getString(1);
            arrlist.add(new CongViec(id,ten));
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
        adapter = new CustomerAdapter(MainActivity.this,arrlist);
        lv.setAdapter(adapter);
    }
}
