package com.example.amd.student_manager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AMD on 12/2/2017.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<Course> arrayList;

    public SpinnerAdapter(Context context, ArrayList<Course> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class Viewholder{
        ImageView imgsua,imgxoa;
        TextView tv_course_id,tv_course_name,tv_course_phone;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        LayoutInflater inf= ((Activity)context).getLayoutInflater();
        if(view==null){
            holder =new Viewholder();
            view=inf.inflate(R.layout.spinner_list_course,null);
            holder.tv_course_name=(TextView)view.findViewById(R.id.textView2);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
        Course c=arrayList.get(i);
        holder.tv_course_name.setText("Năm học "+c.name);
        return view;
    }
}
