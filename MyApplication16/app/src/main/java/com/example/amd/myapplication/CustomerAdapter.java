package com.example.amd.myapplication;

import android.app.Activity;
import android.content.Context;
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
 * Created by AMD on 10/27/2017.
 */

public class CustomerAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<CongViec> arrcongviec;
    private ArrayList<CongViec> filterlist;
    CustomerFilter filter;

    public CustomerAdapter(Context context, ArrayList<CongViec> arrcongviec) {
        this.context = context;
        this.arrcongviec = arrcongviec;
        this.filterlist =arrcongviec;
    }

    @Override
    public int getCount() {
        return arrcongviec.size();
    }

    @Override
    public Object getItem(int i) {
        return arrcongviec.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrcongviec.indexOf(arrcongviec.get(i));
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomerFilter();
        }
        return filter;
    }

    private class ViewHolder{
        TextView tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder ;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view=inflater.inflate(R.layout.tencongviec,null,true);
            holder.tv=(TextView)view.findViewById(R.id.textView);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
     CongViec cv=arrcongviec.get(i);
        holder.tv.setText(cv.getTencongviec());
        return view;
    }
    class CustomerFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if(charSequence != null && charSequence.length()>0){
                charSequence=charSequence.toString().toUpperCase();
                ArrayList<CongViec> filters= new ArrayList<>();
                for(int i=0;i<filterlist.size();i++){
                    if(filterlist.get(i).getTencongviec().toUpperCase().contains(charSequence)){
                        CongViec p = new CongViec(filterlist.get(i).getIdcongviec(),filterlist.get(i).getTencongviec());
                        filters.add(p);}
                }
                results.count=filters.size();
                results.values=filters;

            }
            else{
                results.count=filterlist.size();
                results.values=filterlist;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arrcongviec= (ArrayList<CongViec>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
