package com.example.amd.android_27_10_2017_tuan1;

import android.app.Activity;
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
 * Created by AMD on 10/27/2017.
 */

public class Adapter extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<Player> arrayList;
    private ArrayList<Player> filterlist;
    CustomerFilter filter;

    public Adapter(Context context, ArrayList<Player> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.filterlist=arrayList;
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
    private class  ViewHolder{
        TextView tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder= new ViewHolder();
            LayoutInflater inflater= ((Activity)context).getLayoutInflater();
            view = inflater.inflate(R.layout.players,null);
            holder.tv=(TextView)view.findViewById(R.id.textView);
            view.setTag(holder);
        }
        else{
            holder= (ViewHolder) view.getTag();
        }
        Player p = arrayList.get(i);
        holder.tv.setText(p.getTen());
        return view;
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter = new CustomerFilter();
        }
        return filter;
    }
   class CustomerFilter extends Filter {
       @Override
       protected FilterResults performFiltering(CharSequence charSequence) {
           FilterResults results =new FilterResults();
           if(charSequence!=null&&charSequence.length()>0){
               charSequence=charSequence.toString().toUpperCase();
               ArrayList<Player> filters= new ArrayList<>();
               for(int i=0;i<arrayList.size();i++){
                   if(filterlist.get(i).getTen().toUpperCase().contains(charSequence)){
                       Player p = new Player(filterlist.get(i).getId(),filterlist.get(i).getTen());
                       filters.add(p);
                   }
               }
              results.values=filters;
               results.count=filters.size();
           }
           else{
               results.values=filterlist;
               results.count=filterlist.size();
           }
           return results;
       }

       @Override
       protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arrayList= (ArrayList<Player>) filterResults.values;
           notifyDataSetChanged();
       }
   }
}
