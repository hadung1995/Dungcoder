package com.example.amd.assignmenmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map_googleActivity extends AppCompatActivity implements OnMapReadyCallback {
    Double latitude;
    Double longtitude;
    String name;
    String des;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_google);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mymap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        latitude=getIntent().getExtras().getDouble("latitude");
        longtitude=getIntent().getExtras().getDouble("longtitude");
        name=getIntent().getExtras().getString("name");
        des=getIntent().getExtras().getString("description");
        LatLng latlng = new LatLng(latitude,longtitude);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15));
        map.addMarker(new MarkerOptions()
                .title(name)
                .snippet(des)
                .position(latlng));
    }
    }

