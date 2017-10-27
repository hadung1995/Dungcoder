package com.example.amd.metvoisqlite;

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

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BaiLam> baiLamList;

    public CustomAdapter(Context context, int layout, List<BaiLam> baiLamList) {
        this.context = context;
        this.layout = layout;
        this.baiLamList = baiLamList;
    }

    @Override
    public int getCount() {
        return baiLamList.size();
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
        TextView txtten;
        ImageView imgedit,imgdelete;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtten=(TextView)view.findViewById(R.id.tvcongviec);
            holder.imgedit=(ImageView)view.findViewById(R.id.imgedit);
            holder.imgdelete=(ImageView)view.findViewById(R.id.imgdelete);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view .getTag();
        }
        BaiLam bailam = baiLamList.get(i);
        holder.txtten.setText(bailam.getTenCV());
        return view;
    }
}
