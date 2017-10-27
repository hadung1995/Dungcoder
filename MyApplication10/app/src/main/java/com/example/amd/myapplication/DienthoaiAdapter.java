package com.example.amd.myapplication;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by AMD on 10/25/2017.
 */

public class DienthoaiAdapter extends BaseAdapter implements Filterable {
    private ArrayList<DienThoai> arrdienthoai;
    private Context context;
    private ValueFilter valueFilter;
    private ArrayList<DienThoai> arrfilterlist;

    public DienthoaiAdapter(ArrayList<DienThoai> arrdienthoai, Context context) {
        super();
        this.arrdienthoai = arrdienthoai;
        this.context = context;
        this.arrfilterlist=arrdienthoai;
        getFilter();
    }

    @Override
    public int getCount() {
        return arrdienthoai.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder {
        TextView tname, tplace;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
            holder.tname = (TextView) view.findViewById(R.id.product_name);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final DienThoai cv = arrdienthoai.get(i);
        holder.tname.setText(cv.getDienThoai());
        return view;
    }
        @Override
        public Filter getFilter(){
            if(valueFilter==null) {

                valueFilter=new ValueFilter();
            }

            return valueFilter;
        }
    private class ValueFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null && constraint.length()>0){
                ArrayList<DienThoai> filterList=new ArrayList<DienThoai>();
                for(int i=0;i<arrfilterlist.size();i++){
                    if((arrfilterlist.get(i).getDienThoai().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        DienThoai contacts=new DienThoai();
                        contacts.setDienThoai(arrfilterlist.get(i).getDienThoai());
                        filterList.add(contacts);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=arrfilterlist.size();
                results.values=arrdienthoai;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        }
    }
}
