package com.example.amd.lamlaibaitest_android_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMD on 10/18/2017.
 */

public class CustomerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CongViec> congViecList;

    public CustomerAdapter(Context context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
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
        ImageView imghinh1,imghinh2;
        TextView tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
             holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.tv=(TextView)view.findViewById(R.id.tvcongviec);
            holder.imghinh1=(ImageView)view.findViewById(R.id.imghinhsua);
            holder.imghinh2=(ImageView)view.findViewById(R.id.imghinhxoa);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        CongViec cv = congViecList.get(i);
        holder.tv.setText(cv.getTencongviec());
        return view;
    }
}
