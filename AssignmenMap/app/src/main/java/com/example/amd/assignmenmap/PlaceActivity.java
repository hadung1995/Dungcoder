package com.example.amd.assignmenmap;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.provider.MediaStore;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.io.ByteArrayOutputStream;
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
    ImageView img_hinh,img_hinh1;
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
        img_hinh=(ImageView)dialog.findViewById(R.id.image_view_add);
        Button btn_confirm=(Button)dialog.findViewById(R.id.button4);
        img_hinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pick=new Intent(Intent.ACTION_GET_CONTENT);
                pick.setType("image/*");
                Intent pho=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent chosser=Intent.createChooser(pick, "chon");
                chosser.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pho});
                startActivityForResult(chosser, 999);
            }
        });
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
                //
                BitmapDrawable bitmapDrawable= (BitmapDrawable) img_hinh.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrays = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrays);
                byte[] hinhanh=byteArrays.toByteArray();
                //

                db.themplace(new Place(name,address,latitude,longtitude,des,hinhanh));
                dodulieu();
                Toast.makeText(PlaceActivity.this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void dialog_place_sua(final Place p){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.up_place);
        final EditText et_name=(EditText)dialog.findViewById(R.id.editText_up_name);
        final EditText et_address=(EditText)dialog.findViewById(R.id.editText_up_Address);
        final EditText et_description=(EditText)dialog.findViewById(R.id.editText_up_Description);
        img_hinh1 =(ImageView)dialog.findViewById(R.id.image_view_up);
        Button btn=(Button)dialog.findViewById(R.id.button_up_place);
        et_name.setText(p.name);
        et_address.setText(p.address);
        et_description.setText(p.description);
        byte[] hinhanh = p.picture;
        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        img_hinh1.setImageBitmap(bitmap);
        img_hinh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pick=new Intent(Intent.ACTION_GET_CONTENT);
                pick.setType("image/*");
                Intent pho=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent chosser=Intent.createChooser(pick, "chon");
                chosser.putExtra(Intent.EXTRA_INITIAL_INTENTS,new Intent[]{pho});
                startActivityForResult(chosser, 777);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.name=et_name.getText().toString();
                p.address=et_address.getText().toString();
                p.description=et_description.getText().toString();
                BitmapDrawable bitmapDrawable= (BitmapDrawable) img_hinh1.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrays = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrays);
                byte[] hinhanh=byteArrays.toByteArray();
                List<Address> geocodeMatches = null;
                try {
                    geocodeMatches =
                            new Geocoder(PlaceActivity.this).getFromLocationName(
                                    p.address, 1);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (!geocodeMatches.isEmpty())
                {
                    latitude = geocodeMatches.get(0).getLatitude();
                    longtitude = geocodeMatches.get(0).getLongitude();
                }
                p.picture=hinhanh;
                db.suaPlace(p);
                dodulieu();
                Toast.makeText(PlaceActivity.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        dialog.show();

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==999&&resultCode==RESULT_OK&&data!=null){
            if(data.getExtras()!=null)
            {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                img_hinh.setImageBitmap(imageBitmap);
            }
            else{
                Uri uri=data.getData();
                img_hinh.setImageURI(uri);
            }









        }
        if(requestCode==777&&resultCode==RESULT_OK&&data!=null){
            if(data.getExtras()!=null)
            {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                img_hinh1.setImageBitmap(imageBitmap);
            }
            else{
                Uri uri=data.getData();
                img_hinh1.setImageURI(uri);
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}}
