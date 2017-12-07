package com.example.amd.student_manager;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectFragment extends Fragment {
    int id;
    SubjectFragmentAdapter adapter;
    Database db;
    ArrayList<Subject> arrayList=new ArrayList<>();
    ListView lv;
    int course_id;
    EditText et_monhoc;


    public SubjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_subject, container, false);
        lv=(ListView)view.findViewById(R.id.list_view_sb);
        et_monhoc=(EditText)view.findViewById(R.id.editText);
        id=getArguments().getInt("so");
        course_id=getArguments().getInt("so2");
        db=new Database(getActivity());
        dodulieu113();
        et_monhoc.addTextChangedListener(new TextWatcher() {
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
    public void dodulieu113(){
        arrayList=db.xemsubject(id);
        adapter=new SubjectFragmentAdapter(getActivity(),arrayList);
        lv.setAdapter(adapter);
    }


}
