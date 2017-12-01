package com.example.amd.fragment_1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChuFragment extends Fragment {


    TextView tv,tv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_page, container, false);
        tv=(TextView)v.findViewById(R.id.textView);
        tv2=(TextView)v.findViewById(R.id.textView2);
        String chuoi=getArguments().getString("chu");
        tv.setText(chuoi);

        Bundle args = getArguments();
        int index = args.getInt("so");
        tv2.setText(""+index);
        return v;
    }


}
