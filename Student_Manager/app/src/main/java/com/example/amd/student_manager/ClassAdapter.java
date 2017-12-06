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

public class ClassAdapter extends BaseAdapter {
    Context context;
    ArrayList<Class> arrayList;

    public ClassAdapter(Context context, ArrayList<Class> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i).id;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Viewholder{
        ImageView imgsua,imgxoa;
        TextView tv_class_id,tv_class_name,tv_class_train,tv_class_course_id;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        LayoutInflater inf= ((Activity)context).getLayoutInflater();
        if(view==null){
            holder =new Viewholder();
            view=inf.inflate(R.layout.class_list,null);
            holder.imgsua=(ImageView)view.findViewById(R.id.img_update_class);
            holder.imgxoa=(ImageView)view.findViewById(R.id.img_delete_class);
            holder.tv_class_id=(TextView)view.findViewById(R.id.class_id);
            holder.tv_class_name=(TextView)view.findViewById(R.id.class_name);
            holder.tv_class_train=(TextView)view.findViewById(R.id.class_train);
            holder.tv_class_course_id=(TextView)view.findViewById(R.id.class_course);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
        final Class cl=arrayList.get(i);
        holder.tv_class_id.setText(""+cl.id);
        holder.tv_class_name.setText("Tên lớp: "+cl.name);
        holder.tv_class_train.setText("Hệ đào tạo: "+cl.train);
        holder.tv_class_course_id.setText("Khóa: "+cl.course_id);
        holder.imgxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ClassActivity) context).db.xoaClass(cl.course_id,cl.id);
                ((ClassActivity) context).dodulieu();
            }
        });
        holder.imgsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ClassActivity)context).dialogsua(cl);

            }
        });
        return view;
    }
}
