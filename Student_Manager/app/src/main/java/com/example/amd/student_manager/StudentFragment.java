package com.example.amd.student_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
    EditText et_student;
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
        et_student=(EditText)view.findViewById(R.id.editText4);
        db=new Database(getActivity());
        id=getArguments().getInt("so1");
        dodulieu();
        et_student.addTextChangedListener(new TextWatcher() {
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
        return view;
    }
    public void dodulieu(){
        arrayList=db.xemStudent(id);
        adapter=new StudentAdapter(getActivity(),arrayList);
        lv.setAdapter(adapter);
    }


}
