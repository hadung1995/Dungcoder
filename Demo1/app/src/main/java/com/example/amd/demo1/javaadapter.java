package com.example.amd.demo1;

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

public class javaadapter extends BaseAdapter {
    private Context context;
    private int layout;
    List<java> javaList;

    public javaadapter(Context context, int layout, List<java> javaList) {
        this.context = context;
        this.layout = layout;
        this.javaList = javaList;
    }

    @Override

    public int getCount() {
        return javaList.size();
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtho=(TextView)view.findViewById(R.id.txtv1);
            holder.txtten=(TextView)view.findViewById(R.id.txtv2);
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder)view.getTag(i);
        }

        //
        java jav = javaList.get(i);
        holder.txtho.setText(jav.getHo());
        holder.txtten.setText(jav.getTen());

        return view;
    }
}
