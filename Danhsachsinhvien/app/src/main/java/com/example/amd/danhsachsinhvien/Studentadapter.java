package com.example.amd.danhsachsinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMD on 10/6/2017.
 */

public class Studentadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> studentList;

    public Studentadapter(Context context, int layout, List<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        TextView txtid,txtname;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflat = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflat.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtid=(TextView)view.findViewById(R.id.tvid);
            holder.txtname=(TextView)view.findViewById(R.id.tvten);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder)view.getTag(i);
        }
        Student std = studentList.get(i);
        holder.txtname.setText(std.getStudent_name());
        holder.txtid.setText(""+std.getStudent_id());
        return view;
    }
}
