package com.example.amd.android_sqlite_searchview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AMD on 10/26/2017.
 */

public class Adapter extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<CongViec> CongViecs;
    CustomFilter filter;
    ArrayList<CongViec> CongVieclist;

    public Adapter(Context c, ArrayList<CongViec> congViecs) {
        this.c = c;
        this.CongViecs = congViecs;
        this.CongVieclist = congViecs;
    }

    @Override
    public int getCount() {
        return CongViecs.size();
    }

    @Override
    public Object getItem(int i) {
        return CongViecs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return CongViecs.indexOf(getItem(i));
    }
    public class ViewHolder{

        TextView tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            holder = new ViewHolder();
            view=inflater.inflate(R.layout.dong_cong_viec,null);
            holder.tv=(TextView)view.findViewById(R.id.tencongviec);

            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        CongViec cv = CongViecs.get(i);
        holder.tv.setText(cv.getTencongviec());
        return view;
    }

    @Override
    public Filter getFilter() {
        if(filter == null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }
    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                constraint=constraint.toString().toUpperCase();
            ArrayList<CongViec> filters=new ArrayList<>();
            for(int i=0;i<CongVieclist.size();i++)
            {
                if(CongVieclist.get(i).getTencongviec().toUpperCase().contains(constraint))
                {
                    CongViec p=new CongViec(CongVieclist.get(i).getIdcongviec(), CongVieclist.get(i).getTencongviec());
                    filters.add(p);
                }
            }
            results.count=filters.size();
            results.values=filters;}
            else{
                results.count=CongVieclist.size();
                results.values=CongVieclist;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            CongViecs=(ArrayList<CongViec>)filterResults.values;
            notifyDataSetChanged();
        }
    }

}
