package com.example.amd.androidvssqlitepickturepick;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMD on 10/23/2017.
 */

public class CongViecAdapter extends BaseAdapter {
    private Context context;
    private List<CongViec> arrcongviec;

    public CongViecAdapter(Context context, List<CongViec> arrcongviec) {
        this.context = context;
        this.arrcongviec = arrcongviec;
    }

    @Override
    public int getCount() {
        return arrcongviec.size();
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
        ImageView imgadd,imgdelete;
        TextView tvcv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view=inflater.inflate(R.layout.congviec_foradapter,null);
            holder.imgadd=(ImageView)view.findViewById(R.id.imageView);
            holder.imgdelete=(ImageView)view.findViewById(R.id.imageView2);
            holder.tvcv=(TextView)view.findViewById(R.id.textViewCV);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
        CongViec cv = arrcongviec.get(i);
        holder.tvcv.setText(cv.getTen());
        return view;
    }
}
