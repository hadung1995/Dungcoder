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
 * Created by HP on 12/6/2017.
 */

public class SubjectFragmentAdapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<Subject> arrayList;
    ArrayList<Subject> arrayfilter;
    private ValueFilter valueFilter;

    public SubjectFragmentAdapter(Context context, ArrayList<Subject> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayfilter=arrayList;
        getFilter();
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
        ImageView imgsua,imgxoa;
        TextView subject_name,subject_id,subject_class_id;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        LayoutInflater inf= ((Activity)context).getLayoutInflater();
        if(view==null){
            holder =new Viewholder();
            view=inf.inflate(R.layout.subject_list,null);
            holder.imgsua=(ImageView)view.findViewById(R.id.img_update_subject);
            holder.imgxoa=(ImageView)view.findViewById(R.id.img_delete_subject);
            holder.subject_name=(TextView)view.findViewById(R.id.subject_name);
            holder.subject_id=(TextView)view.findViewById(R.id.subject_id);
            holder.subject_class_id=(TextView)view.findViewById(R.id.class_id_subject);
            view.setTag(holder);
        }
        else{
            holder= (Viewholder) view.getTag();
        }
        final Subject subject=arrayList.get(i);
        holder.subject_id.setText(""+subject.s_id);
        holder.subject_class_id.setText(subject.class_id+"");
        holder.subject_name.setText(subject.s_name);

        holder.imgsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Student_SubjectActivity)context).sua_subject(subject);
            }
        });
        holder.imgxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Student_SubjectActivity)context).db.xoasubject(subject.s_id);

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
                ArrayList<Subject> filterList=new ArrayList<Subject>();
                for(int i=0;i<arrayfilter.size();i++){
                    if((arrayfilter.get(i).s_name.toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        Subject c = new Subject();
                        c=arrayfilter.get(i);
                        filterList.add(c);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=arrayfilter.size();
                results.values=arrayfilter;
            }
            return results;
        }


        //Invoked in the UI thread to publish the filtering results in the user interface.
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            arrayList=(ArrayList<Subject>) results.values;
            notifyDataSetChanged();
        }
    }
}
