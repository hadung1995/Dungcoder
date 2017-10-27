package com.example.amd.android_sqlite_searchviewsample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    CustomAdapter adapter;
    ArrayList<Player> arrplayer;
    SearchView sv;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      sv=(SearchView)findViewById(R.id.searchView1);
        lv=(ListView)findViewById(R.id.listView1);
        arrplayer = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this,arrplayer);
        lv.setAdapter(adapter);
        database = new Database(MainActivity.this,"SearchView",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS Search(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenPlayer VARCHAR(200))");
        //database.Query("INSERT INTO Search VALUES(null,'Wayne Rooney')");
        getdata();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String arg0) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                // TODO Auto-generated method stub
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
    private void getdata(){
        Cursor getdatacongviec=database.Getdata("SELECT * FROM Search");
        arrplayer.clear();
        while(getdatacongviec.moveToNext()){
            String ten=getdatacongviec.getString(1);
            int id=getdatacongviec.getInt(0);
            arrplayer.add(new Player(id,ten));

        }
        adapter = new CustomAdapter(MainActivity.this,arrplayer);
        lv.setAdapter(adapter);
    }
}
