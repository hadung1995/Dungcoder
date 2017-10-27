package com.example.amd.myapplication;

/**
 * Created by AMD on 10/25/2017.
 */

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
public class Adapter extends BaseAdapter implements Filterable{
    private Context c;
    private ArrayList<Player> players;
    CustomFilter filter;
    private ArrayList<Player> filterList;
    public Adapter(Context ctx,ArrayList<Player> players) {
        // TODO Auto-generated constructor stub
        this.c=ctx;
        this.players=players;
        this.filterList=players;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return players.size();
    }
    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return players.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return players.indexOf(getItem(pos));
    }
    private class ViewHolder{
        ImageView img;
        TextView tv;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // TODO Auto-generated method stub
        LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView=inflater.inflate(R.layout.model, null);
            holder.tv= (TextView) convertView.findViewById(R.id.nameTv);
            holder.img=(ImageView)convertView.findViewById(R.id.imageView1);
            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }



        //SET DATA TO THEM
        holder.tv.setText(players.get(pos).getName());
        holder.img.setImageResource(players.get(pos).getImg());
        return convertView;
    }
    //
    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        if(filter == null)
        {
            filter=new CustomFilter();
        }
        return filter;
    }
    //INNER CLASS
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
                ArrayList<Player> filters=new ArrayList<Player>();
                //get specific items
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getName().toUpperCase().contains(constraint))
                    {
                        Player p=new Player(filterList.get(i).getName(), filterList.get(i).getImg());
                        filters.add(p);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub
            players=(ArrayList<Player>) results.values;
            notifyDataSetChanged();
        }
    }
}
