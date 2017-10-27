package com.example.amd.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    SearchView sv;
    String[] names={"Juan Mata","Jnder Herera","Wayne Rooney","Eden Hazard"};
    int[] images={R.drawable.add,R.drawable.delete,R.drawable.dragon,R.drawable.fire};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.listView1);
        sv=(SearchView) findViewById(R.id.searchView1);
        //ADASPTER
        final Adapter adapter=new Adapter(this, getPlayers());
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
    private ArrayList<Player> getPlayers()
    {
        ArrayList<Player> players=new ArrayList<Player>();
        Player p;
        for(int i=0;i<names.length;i++)
        {
            p=new Player(names[i], images[i]);
            players.add(p);
        }
        return players;
    }
}
