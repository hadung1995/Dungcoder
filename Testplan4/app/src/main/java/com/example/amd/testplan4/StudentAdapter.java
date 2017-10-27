package com.example.amd.testplan4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMD on 10/4/2017.
 */

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> traiList;

    public StudentAdapter(Context context, int layout, List<Student> traiList) {
        this.context = context;
        this.layout = layout;
        this.traiList = traiList;
    }
    @Override
    public int getCount() {
        return traiList.size();
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
        ImageView imgHinh;
        TextView txtten,txtMota;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtten= (TextView) view.findViewById(R.id.txtten);
            holder.txtMota=(TextView)view.findViewById(R.id.txtmota);
            holder.imgHinh=(ImageView)view.findViewById(R.id.imageViewHinh);
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder)view.getTag(i);
        }



        Student traicay = traiList.get(i);
        holder.txtten.setText(traicay.getStudent_id());
        holder.txtMota.setText(traicay.getStudent_name());
        holder.imgHinh.setImageResource(traicay.getHinh());
        return view;
    }
    }

