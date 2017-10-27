package com.example.amd.androidvssqlite2;

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

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CongViec> cv;

    public MenuAdapter(Context context, int layout, List<CongViec> cv) {
        this.context = context;
        this.layout = layout;
        this.cv = cv;
    }

    @Override
    public int getCount() {
        return cv.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return cv.size();
    }
    private class Viewholder{
        TextView tv;
        ImageView imghinh1,imghinh2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        if(view==null){
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.tv=(TextView)view.findViewById(R.id.tvcongviec);
            holder.imghinh1=(ImageView)view.findViewById(R.id.imghinh1) ;
            holder.imghinh2=(ImageView)view.findViewById(R.id.imghinh2) ;
            view.setTag(holder);
        }
        else{
            holder = (Viewholder) view.getTag();
        }
        CongViec congviec = cv.get(i);
        holder.tv.setText(congviec.getTencongviec());
        return view;
    }
}
