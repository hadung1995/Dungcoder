package com.example.amd.searchviewsample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<AnimalNames> animalNamesList = null;
    private ArrayList<AnimalNames> arraylist;

    public ListViewAdapter(Context context, List<AnimalNames> animalNamesList) {
        mContext = context;
        this.animalNamesList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<AnimalNames>();
        this.arraylist.addAll(animalNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return animalNamesList.size();
    }

    @Override
    public AnimalNames getItem(int position) {
        return animalNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.search_list_view_item, null);
            // Locate the TextViews in search_list_view_itemiew_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews

        holder.name.setText(animalNamesList.get(position).getAnimalName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("keshav","click  list item ->"+animalNamesList.get(position).getAnimalName());
                v.editsearch.setQuery(animalNamesList.get(position).getAnimalName(), false);

                Log.e("keshav","click  size ->"+animalNamesList.size());
                // TOdo size always 1 Important See cs Electric Project in Holostik
                Log.e("keshav","click  size ->"+animalNamesList.get(0).getAnimalName());
            }
        });
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        animalNamesList.clear();
        if (charText.length() == 0) {
            animalNamesList.addAll(arraylist);
        } else {
            for (AnimalNames wp : arraylist) {
                if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    animalNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}