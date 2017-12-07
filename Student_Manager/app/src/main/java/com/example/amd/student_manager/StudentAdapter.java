package com.example.amd.student_manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AMD on 12/3/2017.
 */

public class StudentAdapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<Student> arrayList;
    ArrayList<Student> arrayListfilter;
    private ValueFilter valueFilter;

    public StudentAdapter(Context context, ArrayList<Student> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayListfilter=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
    public Filter getFilter() {
        if(valueFilter==null) {

            valueFilter=new ValueFilter();
        }
        return valueFilter;
    }

    public class Viewholder{
        ImageView imgsua,imgxoa,imghinh;
        TextView tv_student_id,tv_student_name,tv_student_class_id,tv_student_sex,tv_student_dob;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        LayoutInflater inf= ((Activity)context).getLayoutInflater();
        if(view==null){
            holder =new Viewholder();
            view=inf.inflate(R.layout.student_list,null);
            holder.imgsua=(ImageView)view.findViewById(R.id.update_student);
            holder.imgxoa=(ImageView)view.findViewById(R.id.delete_student);
            holder.tv_student_name=(TextView)view.findViewById(R.id.student_name_list);
            holder.tv_student_class_id=(TextView)view.findViewById(R.id.student_class_list);
            holder.tv_student_dob=(TextView)view.findViewById(R.id.student_dob_list);
            holder.tv_student_sex=(TextView)view.findViewById(R.id.student_sex_list);
            holder.tv_student_id=(TextView)view.findViewById(R.id.student_id_list);
            holder.imghinh=(ImageView)view.findViewById(R.id.student_picture_list);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
            final Student std=arrayList.get(i);
            holder.tv_student_id.setText(""+std.id);
            holder.tv_student_name.setText(std.name);
            holder.tv_student_dob.setText(std.dob);
            holder.tv_student_sex.setText(std.sex);
            holder.tv_student_class_id.setText(""+std.class_id);
            byte[] hinhanh = std.picture;
            Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
            holder.imghinh.setImageBitmap(bitmap);
            holder.imgsua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Student_SubjectActivity)context).student_dialog(std);
                }
            });
            holder.imgxoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Student_SubjectActivity) context).db.xoaStudent(std.id);
                    ((Student_SubjectActivity) context).finish();
                }
            });
        return view;
    }
    private class ValueFilter extends Filter {

        //Invoked in a worker thread to filter the data according to the constraint.
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null && constraint.length()>0){
                ArrayList<Student> filterList=new ArrayList<Student>();
                for(int i=0;i<arrayListfilter.size();i++){
                    if((arrayListfilter.get(i).name.toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        Student c = new Student();
                        c=arrayListfilter.get(i);
                        filterList.add(c);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=arrayListfilter.size();
                results.values=arrayList;
            }
            return results;
        }


        //Invoked in the UI thread to publish the filtering results in the user interface.
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            arrayList=(ArrayList<Student>) results.values;
            notifyDataSetChanged();
        }
    }
}
