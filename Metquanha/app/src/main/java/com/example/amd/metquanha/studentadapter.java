package com.example.amd.metquanha;

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

public class studentadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> studentList;

    public studentadapter(Context context, int layout, List<Student> studentList) {
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
    private class ViewHolder{
        TextView txtho,txtten;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtho=(TextView)view.findViewById(R.id.txtv1);
            holder.txtten=(TextView)view.findViewById(R.id.txtv2);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder)view.getTag(i);
        }

        Student std= studentList.get(i);
        holder.txtho.setText(std.getHo());
        holder.txtten.setText(std.getTen());
        return view;
    }
}
