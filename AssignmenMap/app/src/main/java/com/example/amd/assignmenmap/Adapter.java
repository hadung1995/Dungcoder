package com.example.amd.assignmenmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
 * Created by AMD on 12/7/2017.
 */

public class Adapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<Place> arrayList;
    ArrayList<Place> arrayfilter;
    private ValueFilter valueFilter;

    public Adapter(Context context, ArrayList<Place> arrayList) {

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

    private  class Viewholder{
        ImageView imgmap,img_place,img_sua,img_xoa;
        TextView tv_id,tv_name,tv_address,tv_lat,tv_long,tv_des;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder;
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        if(view==null){
            viewholder =new Viewholder();
            view=inflater.inflate(R.layout.dong_place,null);
            viewholder.imgmap=(ImageView)view.findViewById(R.id.imageView);
            viewholder.img_sua=(ImageView)view.findViewById(R.id.imageView2);
            viewholder.img_xoa=(ImageView)view.findViewById(R.id.imageView3);
            viewholder.tv_id=(TextView)view.findViewById(R.id.textView2);
            viewholder.tv_name=(TextView)view.findViewById(R.id.textView3);
            viewholder.tv_address=(TextView)view.findViewById(R.id.textView4);
            viewholder.tv_lat=(TextView)view.findViewById(R.id.textView5);
            viewholder.tv_long=(TextView)view.findViewById(R.id.textView6);
            viewholder.tv_des=(TextView)view.findViewById(R.id.textView7);

            view.setTag(viewholder);
        }
        viewholder= (Viewholder) view.getTag();
            final Place p=arrayList.get(i);
        viewholder.tv_id.setText(""+p.id);
        viewholder.tv_name.setText(p.name);
        viewholder.tv_address.setText(p.address);
        viewholder.tv_lat.setText(""+p.latitude);
        viewholder.tv_long.setText(""+p.longtitude);
        viewholder.tv_des.setText(p.description);
        viewholder.imgmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double latitude1=p.latitude;
                Double longtitude1=p.longtitude;
                String name=p.name;
                String des=p.description;
                Intent intent =new Intent(context,map_googleActivity.class);
                intent.putExtra("latitude",latitude1);
                intent.putExtra("longtitude",longtitude1);
                intent.putExtra("description",des);
                intent.putExtra("name",name);
                context.startActivity(intent);

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
                ArrayList<Place> filterList=new ArrayList<Place>();
                for(int i=0;i<arrayfilter.size();i++){
                    if((arrayfilter.get(i).name.toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        Place c = new Place();
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
            arrayList=(ArrayList<Place>) results.values;
            notifyDataSetChanged();
        }
    }
}

