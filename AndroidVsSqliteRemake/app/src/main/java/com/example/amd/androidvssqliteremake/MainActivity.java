package com.example.amd.androidvssqliteremake;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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
        /*arrcongviec=new ArrayList<>();
        adapter=new CongViecAdapter(MainActivity.this,arrcongviec);
        lv.setAdapter(adapter);*/

        database = new Database(MainActivity.this,"ghinho.sqlite",null,1);
        database.Query("CREATE TABLE IF NOT EXISTS CongViec(Id Integer PRIMARY KEY AUTOINCREMENT, TenCV varchar(200),Link varchar(200))");
        database.Query("INSERT INTO CongViec VALUES(null,'Bai tap 3',http://google.com)");
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
    public void dialogxoa(final int id){
        AlertDialog.Builder dialogxoa = new AlertDialog.Builder(this);

        dialogxoa.setMessage("Ban co thuc su muon xoa thu nay khong?");

        dialogxoa.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.Query("DELETE FROM CongViec WHERE Id ='"+id+"'");
                GetDaTaCV();
            }
        });
        dialogxoa.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogxoa.show();
    }
    public void dialogsua(final int id, String tencv){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua);
        Button btnconfirm=(Button)dialog.findViewById(R.id.btnconfirm);
        Button btnabort=(Button)dialog.findViewById(R.id.btnabort);
        final EditText etsua=(EditText)dialog.findViewById(R.id.editsua);
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
                String tensuacongviec=etsua.getText().toString();
                database.Query("UPDATE CongViec SET TenCV='"+tensuacongviec+"' WHERE Id='"+id+"'");
                dialog.dismiss();
                GetDaTaCV();
                Toast.makeText(MainActivity.this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
*/
    private void GetDaTaCV(){
        Cursor datacongviec = database.GetDaTa("SELECT * FROM CongViec");arrcongviec.clear();
        while(datacongviec.moveToNext()){
            String tencongviec=datacongviec.getString(1);
            int id=datacongviec.getInt(0);

            String link=datacongviec.getString(2);
            Toast.makeText(this, link, Toast.LENGTH_SHORT).show();
            arrcongviec.add(new CongViec(id,tencongviec,link));
        }
        adapter=new CongViecAdapter(MainActivity.this,arrcongviec);
        lv.setAdapter(adapter);
    }

}
