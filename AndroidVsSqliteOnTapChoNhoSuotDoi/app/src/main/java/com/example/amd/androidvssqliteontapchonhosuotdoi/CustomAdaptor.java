package com.example.amd.androidvssqliteontapchonhosuotdoi;

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
import java.util.List;
import java.util.Locale;

/**
 * Created by AMD on 10/19/2017.
 */

public class CustomAdaptor extends BaseAdapter implements Filterable {
    private MainActivity context;
    private int layout;
    private ArrayList<CongViec> arrcv;
    private ArrayList<CongViec> filterlist;
    CustomFilter filter;

    public CustomAdaptor(MainActivity context, int layout, ArrayList<CongViec> arrcv) {
        this.context = context;
        this.layout = layout;
        this.arrcv = arrcv;
        this.filterlist=arrcv;
    }

    @Override
    public int getCount() {
        return arrcv.size();
    }

    @Override
    public Object getItem(int i) {
        return arrcv.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arrcv.indexOf(getItem(i));
    }


    private class ViewHolder{
        TextView tv;
        ImageView img1,img2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(layout,null);
            holder.tv=(TextView)view.findViewById(R.id.tencongviec);
            holder.img1=(ImageView)view.findViewById(R.id.imghinhadd);
            holder.img2=(ImageView)view.findViewById(R.id.imghinhdelete);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
        final CongViec cv = arrcv.get(i);
        holder.tv.setText(cv.getTencongviec());
        return view;
    }
    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomFilter();
        }
        return filter;
    }
    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub
            //Filter Result là gì?
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();
                ArrayList<CongViec> filters=new ArrayList<CongViec>();
                //get specific items
                for(int i=0;i<filterlist.size();i++)
                {
                    if(filters.get(i).getTencongviec().toUpperCase().contains(constraint))
                    {
                        CongViec p=new CongViec(filterlist.get(i).getIdcongviec(), filterlist.get(i).getTencongviec());
                        filters.add(p);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else
            {
                results.count=filterlist.size();
                results.values=filterlist;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub
            arrcv=(ArrayList<CongViec>) results.values;
            notifyDataSetChanged();
        }
    }

}
