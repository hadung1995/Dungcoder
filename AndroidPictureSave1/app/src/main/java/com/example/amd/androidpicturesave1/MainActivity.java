package com.example.amd.androidpicturesave1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ArrayList<Hinhanh> arrhinhanh;
    CustomAdaptor adaptor;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listviewcv);
        String link="https://imgur.com/DvpvklR.png";
        database=new Database(MainActivity.this,"hinhanh.sqlite",null,1);
        arrhinhanh = new ArrayList<>();
        adaptor = new CustomAdaptor(MainActivity.this,arrhinhanh);
        lv.setAdapter(adaptor);
        database.Query("CREATE TABLE IF NOT EXISTS HinhAnh(Id INTEGER PRIMARY KEY AUTOINCREMENT,Link varchar(200))");
        getdatacv();

    }
    private void getdatacv(){
        Cursor datacongviec = database.GetDaTa("SELECT * FROM HinhAnh");
        while(datacongviec.moveToNext()){
            String link=datacongviec.getString(1);
            int id=datacongviec.getInt(0);
            Toast.makeText(this, link, Toast.LENGTH_SHORT).show();
            arrhinhanh.add(new Hinhanh(id,link));
        }
        adaptor = new CustomAdaptor(MainActivity.this,arrhinhanh);
        lv.setAdapter(adaptor);
    }
}
