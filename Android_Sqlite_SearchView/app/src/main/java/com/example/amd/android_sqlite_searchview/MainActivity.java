package com.example.amd.android_sqlite_searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    SearchView sv;
    Adapter adapter;
    String[] names={"Juan Mata","Jnder Herera","Jayne Rooney","Eden Hazard"};
    int[] images={1,2,3,4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listview);
        sv=(SearchView)findViewById(R.id.searchview);
        adapter = new Adapter(MainActivity.this,getPlayers());
        lv.setAdapter(adapter);
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
    private ArrayList<CongViec> getPlayers()
    {
        ArrayList<CongViec> players=new ArrayList<CongViec>();
        CongViec p;
        for(int i=0;i<names.length;i++)
        {
            p=new CongViec(images[i],names[i]);
            players.add(p);
        }
        return players;
    }
}
