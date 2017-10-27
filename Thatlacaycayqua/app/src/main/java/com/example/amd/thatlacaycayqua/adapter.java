package com.example.amd.thatlacaycayqua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMD on 10/5/2017.
 */

public class adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> studentList;

    public adapter(Context context, int layout, List<Student> studentList) {
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
        view=inflater.inflate(layout,null);
        TextView txtho=(TextView)view.findViewById(R.id.textView);
        TextView txtten=(TextView)view.findViewById(R.id.textView2);

        Student std = studentList.get(i);
        txtho.setText(std.getHo());
        txtten.setText(std.getTen());
        return view;
    }
}
