package com.example.amd.contextmenu;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ConstraintLayout manhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        manhinh=(ConstraintLayout)findViewById(R.id.manhinh);

        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
        menu.setHeaderTitle("Chon mau ho cai");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menudo:
                manhinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuvang:
                manhinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuxanh:
                manhinh.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);

    }
}
