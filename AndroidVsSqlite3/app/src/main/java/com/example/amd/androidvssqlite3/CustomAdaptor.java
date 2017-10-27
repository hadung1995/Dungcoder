package com.example.amd.androidvssqlite3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by AMD on 10/19/2017.
 */

public class CustomAdaptor extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<CongViec> arrcv;

    public CustomAdaptor(MainActivity context, int layout, List<CongViec> arrcv) {
        this.context = context;
        this.layout = layout;
        this.arrcv = arrcv;
    }

    @Override
    public int getCount() {
        return arrcv.size();
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
        TextView tv;
        ImageView img1,img2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view=inflater.inflate(R.layout.dong_cong_viec,null,true);
            holder.tv=(TextView)view.findViewById(R.id.tencongviec);
            holder.img1=(ImageView)view.findViewById(R.id.imghinh1);
            holder.img2=(ImageView)view.findViewById(R.id.imghinh2);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
        final CongViec cv = arrcv.get(i);
        holder.tv.setText(cv.getTencongviec());
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.Dialogsua(cv.getIdcongviec(),cv.getTencongviec());
            }
        });
        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.Dialogxoa(cv.getIdcongviec(),cv.getTencongviec());
            }
        });
        return view;
    }
}
