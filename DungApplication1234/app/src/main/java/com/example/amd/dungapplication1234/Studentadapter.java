package com.example.amd.dungapplication1234;

import android.content.Context;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMD on 10/5/2017.
 */

public class Studentadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> studentList;

    public Studentadapter(Context context, int layout, List<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView tvname=(TextView)view.findViewById(R.id.txtten);
        TextView tvid=(TextView)view.findViewById(R.id.txtmota);
        Student std = studentList.get(i);
        tvid.setText(""+std.getStudent_id());
        tvname.setText(std.getStudent_name());
        return view;
}}
