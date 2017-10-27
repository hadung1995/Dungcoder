package com.example.amd.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }
    private void show(){
        PopupMenu popupMenu = new PopupMenu(this,btn);
        popupMenu.getMenuInflater().inflate(R.menu.menu_dong,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menuthem:
                        Toast.makeText(MainActivity.this, "ban da chon menu them", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuxoa:
                        Toast.makeText(MainActivity.this, "ban da cho menu xoa", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menusua:
                        Toast.makeText(MainActivity.this, "ban da cho menu sua", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
