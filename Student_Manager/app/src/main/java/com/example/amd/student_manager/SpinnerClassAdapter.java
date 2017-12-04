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
 * Created by AMD on 12/3/2017.
 */

public class SpinnerClassAdapter extends BaseAdapter {
    Context context;
    ArrayList<Class> arrayList;

    public SpinnerClassAdapter(Context context, ArrayList<Class> arrayList) {
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

        TextView tv_class;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
      Viewholder holder;
        LayoutInflater inf= ((Activity)context).getLayoutInflater();
        if(view==null){
            holder =new Viewholder();
            view=inf.inflate(R.layout.spinner_list_class,null);
            holder.tv_class=(TextView)view.findViewById(R.id.textView8);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
        Class cl=arrayList.get(i);
        holder.tv_class.setText("Lớp"+cl.name);
        return view;
    }
}
