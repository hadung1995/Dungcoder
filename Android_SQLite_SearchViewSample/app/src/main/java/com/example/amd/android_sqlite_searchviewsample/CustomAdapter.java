package com.example.amd.android_sqlite_searchviewsample;


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

public class CustomAdapter extends BaseAdapter implements Filterable {
   Context context;
    ArrayList<Player> players;
    ArrayList<Player> filterlist;
   CustomerFilter filter;

    public CustomAdapter(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
        this.filterlist=players;
    }

    @Override
    public int getCount() {
        return players.size();
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
        ViewHolder holder;
            if(view==null) {
                holder = new ViewHolder();
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                view=inflater.inflate(R.layout.model, null);
                TextView tv = (TextView) view.findViewById(R.id.textView);
                view.setTag(holder);
            }
            else{
                holder= (ViewHolder) view.getTag();
            }
        Player p = players.get(i);
       holder.tv.setText(p.getName());
        return view;
    }
    class CustomerFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if(charSequence!=null&&charSequence.length()>0){
                charSequence=charSequence.toString().toUpperCase();
                ArrayList<Player> filters= new ArrayList<>();
                for(int i=0;i<=filterlist.size();i++){
                    if(filterlist.get(i).getName().toUpperCase().contains(charSequence)){
                    Player p = new Player(filterlist.get(i).getId(),filterlist.get(i).getName());
                    filters.add(p);}
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
           players= (ArrayList<Player>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
