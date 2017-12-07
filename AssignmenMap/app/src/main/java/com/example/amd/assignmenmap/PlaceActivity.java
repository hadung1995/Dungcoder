package com.example.amd.assignmenmap;

import android.app.Dialog;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaceActivity extends AppCompatActivity {
    Database db=new Database(PlaceActivity.this);
    Adapter adapter;
    ArrayList<Place> arrayList;
    ListView lv;
    Double latitude;
    Double longtitude;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        lv=(ListView)findViewById(R.id.lv);
        et=(EditText)findViewById(R.id.edit);
        try {
            db.createDataBase();
            db.close();
            db.openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dodulieu();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void dodulieu(){
        arrayList=new ArrayList<>();
        arrayList=db.xemmap();
        adapter=new Adapter(PlaceActivity.this,arrayList);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_add_place,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuadd){
            showdialogplace();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showdialogplace() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.add_place);
        final EditText et_name=(EditText)dialog.findViewById(R.id.editText7);
        final EditText et_address=(EditText)dialog.findViewById(R.id.editText8);
        final EditText et_description=(EditText)dialog.findViewById(R.id.editText9);
        Button btn_confirm=(Button)dialog.findViewById(R.id.button4);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= et_name.getText().toString();
                String address=et_address.getText().toString();
                String des=et_description.getText().toString();
                List<Address> geocodeMatches = null;
                try {
                    geocodeMatches =
                            new Geocoder(PlaceActivity.this).getFromLocationName(
                                   address, 1);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (!geocodeMatches.isEmpty())
                {
                    latitude = geocodeMatches.get(0).getLatitude();
                    longtitude = geocodeMatches.get(0).getLongitude();
                }
                db.Add_place(new Place(name,address,latitude,longtitude,des));
                dodulieu();
                Toast.makeText(PlaceActivity.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
