package com.example.amd.fragment_1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HinhFragment extends Fragment {

    ImageView iv;
    public HinhFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_hinh, container, false);
        iv=(ImageView)v.findViewById(R.id.imageView);
        iv.setImageResource(getArguments().getInt("hinh"));
        return v;
    }

}
