package com.example.amd.student_manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 12/6/2017.
 */

public class SubjectFragmentAdapter extends BaseAdapter {
    Context context;
    ArrayList<Subject> arrayList;

    public SubjectFragmentAdapter(Context context, ArrayList<Subject> arrayList) {
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
        TextView subject_name,subject_id,subject_class_id;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        LayoutInflater inf= ((Activity)context).getLayoutInflater();
        if(view==null){
            holder =new Viewholder();
            view=inf.inflate(R.layout.subject_list,null);
            holder.imgsua=(ImageView)view.findViewById(R.id.img_update_subject);
            holder.imgxoa=(ImageView)view.findViewById(R.id.img_delete_subject);
            holder.subject_name=(TextView)view.findViewById(R.id.subject_name);
            holder.subject_id=(TextView)view.findViewById(R.id.subject_id);
            holder.subject_class_id=(TextView)view.findViewById(R.id.class_id_subject);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
        final Subject subject=arrayList.get(i);
        holder.subject_id.setText(""+subject.s_id);
        holder.subject_class_id.setText(subject.class_id+"");
        holder.subject_name.setText(subject.s_name);

        holder.imgsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Student_SubjectActivity)context).sua_subject(subject);
            }
        });
        holder.imgxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Student_SubjectActivity)context).db.xoasubject(subject.s_id);

            }
        });
        return view;
    }
}
