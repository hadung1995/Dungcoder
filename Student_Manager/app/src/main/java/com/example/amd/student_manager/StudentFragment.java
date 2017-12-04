package com.example.amd.student_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {
    Database db;
    StudentAdapter adapter;
    ArrayList<Student> arrayList=new ArrayList<>();
    ListView lv;
    int id;
    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_student, container, false);
        lv=(ListView)view.findViewById(R.id.list_view_std) ;
        db=new Database(getActivity());
        id=getArguments().getInt("so1");
        arrayList=db.xemStudent(id);
        adapter=new StudentAdapter(getActivity(),arrayList);
        lv.setAdapter(adapter);
        return view;
    }


}
