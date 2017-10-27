package com.example.amd.metvoisqlite;

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
    Database database;
    ListView lv;
    ArrayList<BaiLam> arrbailam;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcongviec);
        arrbailam = new ArrayList<>();
        adapter= new CustomAdapter(this,R.layout.dong_bai_lam,arrbailam);
        lv.setAdapter(adapter);

        database = new Database(this,"phainho.sqlite",null,1);

        database.Query("CREATE TABLE IF NOT EXISTS BaiLam(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenViec VARCHAR(200) )");

        //database.Query("INSERT INTO BaiLam VALUES(null,'Viết ứng dụng ghi chú')");

        GetDataCongViec();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuadd){
            DialogThem();
        }

        return super.onOptionsItemSelected(item);
    }

    private void DialogThem(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogthem);
        final EditText editTen = dialog.findViewById(R.id.editten);
        Button btnhuy=dialog.findViewById(R.id.huy);
        Button btnthem=dialog.findViewById(R.id.them);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tencv=editTen.getText().toString();
                if(tencv.equals("")){
                    Toast.makeText(MainActivity.this, "Nhập tên làm ơn", Toast.LENGTH_SHORT).show();
                }
                else{
                    database.Query("INSERT INTO BaiLam Values(null,'"+tencv+"')");
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });
        dialog.show();
    }
    private void GetDataCongViec(){
        Cursor datacongviec = database.Getdata("SELECT * FROM BaiLam");
        arrbailam.clear();
        while(datacongviec.moveToNext()){
            String ten = datacongviec.getString(1);
            int id =datacongviec.getInt(0);
            arrbailam.add(new BaiLam(id,ten));
            Toast.makeText(this,ten, Toast.LENGTH_SHORT).show();
        }
        adapter= new CustomAdapter(this,R.layout.dong_bai_lam,arrbailam);
        lv.setAdapter(adapter);
    }
}
