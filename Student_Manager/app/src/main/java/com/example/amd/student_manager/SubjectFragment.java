package com.example.amd.student_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectFragment extends Fragment {
    ImageView iv;
    TextView tv;
    int id;

    public SubjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_subject, container, false);
        iv=(ImageView)view.findViewById(R.id.imageviewfrag);
        tv=(TextView)view.findViewById(R.id.tv23);
        id=getArguments().getInt("so");
        tv.setText(""+id);
        iv.setImageResource(getArguments().getInt("hinh"));
        return view;
    }

}
