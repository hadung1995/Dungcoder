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
 * Created by AMD on 12/1/2017.
 */

public class CourseAdapter extends BaseAdapter {
    Context context;
    ArrayList<Course> arrayList;

    public CourseAdapter(Context context, ArrayList<Course> arrayList) {
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
            view=inf.inflate(R.layout.course_list,null);
            holder.imgsua=(ImageView)view.findViewById(R.id.imageView2);
            holder.imgxoa=(ImageView)view.findViewById(R.id.imageView3);
            holder.tv_course_id=(TextView)view.findViewById(R.id.textView);
            holder.tv_course_name=(TextView)view.findViewById(R.id.textView2);
            holder.tv_course_phone=(TextView)view.findViewById(R.id.textView4);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
         Course c=arrayList.get(i);
        holder.tv_course_id.setText(""+c.id);
        holder.tv_course_name.setText("Năm học "+c.name);
        holder.tv_course_phone.setText("Liên hệ: "+c.phone);
        holder.imgxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=arrayList.get(i).id;
                ((CourseActivity) context).db.xoaCourse(id);
                ((CourseActivity) context).dodulieu();
            }
        });
        holder.imgsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course c=arrayList.get(i);
                ((CourseActivity) context).suadialog(c);


            }
        });
        return view;
    }
}
