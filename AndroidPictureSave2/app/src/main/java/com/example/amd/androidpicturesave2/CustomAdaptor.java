package com.example.amd.androidpicturesave2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by AMD on 10/19/2017.
 */

public class CustomAdaptor extends BaseAdapter {
   private Context context;
    private List<Hinhanh> arrhinhanh;

    public CustomAdaptor(MainActivity context, List<Hinhanh> arrhinhanh) {
        this.context = context;
        this.arrhinhanh = arrhinhanh;
    }

    @Override
    public int getCount() {
        return arrhinhanh.size();
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
        ImageView imgadd;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view=inflater.inflate(R.layout.congviec_foradapter,null,true);
           holder.imgadd=(ImageView)view.findViewById(R.id.imageview01);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
       Hinhanh hinh = arrhinhanh.get(i);


        Picasso.with(context).load(hinh.getHinhanh()).into(holder.imgadd);
        return view;
    }
}
