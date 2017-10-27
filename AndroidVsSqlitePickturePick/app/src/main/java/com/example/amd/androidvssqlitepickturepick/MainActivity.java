package com.example.amd.androidvssqlitepickturepick;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Database database;
    ArrayList<CongViec> arrcongviec;
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listviewcv);
        arrcongviec=new ArrayList<>();
        adapter=new CongViecAdapter(MainActivity.this,arrcongviec);
        lv.setAdapter(adapter);

        database = new Database(MainActivity.this,"ghinho.sqlite",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id Integer PRIMARY KEY AUTOINCREMENT, TenCV varchar(200))");
        //database.Query("INSERT INTO CongViec VALUES(null,'Bai tap 2')");
        GetDaTaCV();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cv,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuadd){
            dialogthem();
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialogthem(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them);
        Button btnconfirm=(Button)dialog.findViewById(R.id.btnconfirm);
        Button btnabort=(Button)dialog.findViewById(R.id.btnabort);
        final EditText etthem=(EditText)dialog.findViewById(R.id.editthem);
        btnabort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String congviec=etthem.getText().toString();
                if(congviec.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter your work", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.Query("INSERT INTO CongViec VALUES(null,'" + congviec + "')");
                    dialog.dismiss();
                    GetDaTaCV();
                }
            }
        });

        dialog.show();
    }

    private void GetDaTaCV(){
        Cursor datacongviec = database.GetDaTa("SELECT * FROM CongViec");arrcongviec.clear();
        while(datacongviec.moveToNext()){
            String tencongviec=datacongviec.getString(1);
            int id=datacongviec.getInt(0);
            arrcongviec.add(new CongViec(id,tencongviec));
        }
        adapter=new CongViecAdapter(MainActivity.this,arrcongviec);
        lv.setAdapter(adapter);
    }
}
