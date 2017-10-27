package com.example.amd.kinhnghiemlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AMD on 10/5/2017.
 */

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> studentList;

    public StudentAdapter(Context context, int layout, List<Student> studentList) {
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


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

             LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

           TextView tvname=(TextView)view.findViewById(R.id.tvten);
            TextView tvid=(TextView)view.findViewById(R.id.tvid);





        Student std = studentList.get(i);
        tvid.setText(std.getStudent_id());
        tvname.setText(std.getStudent_name());
        // ông thử khai báo bên java cho nó vè kiểu struing xem có chạy ko

        return view;
    }
}