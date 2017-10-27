package com.example.amd.thanhdungsample2;

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
 * Created by AMD on 10/25/2017.
 */

public class CustomAdapter extends BaseAdapter implements Filterable {

    private ArrayList<Contacts> _Contacts;
    private Activity context;
    private LayoutInflater inflater;
    private ValueFilter valueFilter;
    private ArrayList<Contacts> mStringFilterList;

    public CustomAdapter(Activity context, ArrayList<Contacts> _Contacts) {
        super();
        this.context = context;
        this._Contacts = _Contacts;
        mStringFilterList =  _Contacts;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        getFilter();
    }

    @Override
    public int getCount() {
        return _Contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return _Contacts.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView tname, tplace;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.main, null);
            holder.tname = (TextView) convertView.findViewById(R.id.textView1);
            holder.tplace = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        holder.tname.setText("" + _Contacts.get(position).getName());
        holder.tplace.setText("" + "" + _Contacts.get(position).getId());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(valueFilter==null) {

            valueFilter=new ValueFilter();
        }

        return valueFilter;
    }
    private class ValueFilter extends Filter {

        //Invoked in a worker thread to filter the data according to the constraint.
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null && constraint.length()>0){
                ArrayList<Contacts> filterList=new ArrayList<Contacts>();
                for(int i=0;i<mStringFilterList.size();i++){
                    if((mStringFilterList.get(i).getName().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        Contacts contacts = new Contacts();
                        contacts.setName(mStringFilterList.get(i).getName());
                        contacts.setId(mStringFilterList.get(i).getId());
                        filterList.add(contacts);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=mStringFilterList.size();
                results.values=mStringFilterList;
            }
            return results;
        }


        //Invoked in the UI thread to publish the filtering results in the user interface.
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            _Contacts=(ArrayList<Contacts>) results.values;
            notifyDataSetChanged();
        }
    }
}