package com.example.amd.android_27_10_2017_tuan1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ArrayList<Player> arrplayer;
    Adapter adapter;
    ListView lv;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);

        sv=(SearchView) findViewById(R.id.sv);

        arrplayer = new ArrayList<>();

        adapter = new Adapter(MainActivity.this,arrplayer);
        database=new Database(MainActivity.this,"tencauthu.sqlite",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS CauThu(Id INTEGER PRIMARY KEY AUTOINCREMENT,Ten varchar(200))");
        //database.Query("INSERT INTO CauThu VALUES(null,'Cristiano Ronaldo')");
        executedata();
        adapter = new Adapter(MainActivity.this,arrplayer);
        lv.setAdapter(adapter);
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
    private void executedata(){
        Cursor cursor=database.Getdata("SELECT * FROM CauThu");
        while(cursor.moveToNext()){
            String ten=cursor.getString(1);
            int id=cursor.getInt(0);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
            arrplayer.add(new Player(id,ten));
        }
    }
}
