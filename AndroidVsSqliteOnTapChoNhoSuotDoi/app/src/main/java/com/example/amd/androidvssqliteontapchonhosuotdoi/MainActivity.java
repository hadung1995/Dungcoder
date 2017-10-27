package com.example.amd.androidvssqliteontapchonhosuotdoi;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    Database database;
    CustomAdaptor adapter;
    ArrayList<CongViec> arrcv;

SearchView sv;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcongviec);
    sv=(SearchView)findViewById(R.id.searchview);
        arrcv = new ArrayList<>();
        adapter = new CustomAdaptor(MainActivity.this,R.layout.dong_cong_viec,arrcv);
        lv.setAdapter(adapter);


        database = new Database(MainActivity.this,"ghinho.sqlite",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenCV varchar(200))");
        //database.Query("INSERT INTO CongViec VALUES(null,'Bai Tap 2')");
        GetdataCV();
//        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//
//                return true;
//            }
//        });
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
    private void GetdataCV(){
        Cursor datacongviec=database.Getdata("SELECT * FROM CongViec");
        arrcv.clear();
        while(datacongviec.moveToNext()){
            String tencv=datacongviec.getString(1);
            int idcv=datacongviec.getInt(0);
            arrcv.add(new CongViec(idcv,tencv));
        }
        adapter = new CustomAdaptor(MainActivity.this,R.layout.dong_cong_viec,arrcv);
        lv.setAdapter(adapter);
    }
    public void dialogsua(final int id, final String tencv){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua_cong_viec);
        Button btnconfirm=(Button)dialog.findViewById(R.id.btnconfirm);
        Button btnabort=(Button)dialog.findViewById(R.id.btnabort);
        EditText etsua=(EditText)dialog.findViewById(R.id.editsua);
        etsua.setText(tencv);
        btnabort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.Query("UPDATE CongViec SET TenCV='"+tencv+"' WHERE Id = '"+id+"'");
                dialog.dismiss();
                GetdataCV();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        //searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }



}
