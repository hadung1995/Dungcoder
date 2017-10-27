package com.example.amd.quanlysinhvienadapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/**
 * Created by AMD on 10/4/2017.
 */
public class Studentadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> studentList;
    public Studentadapter(Context context, int layout, List<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }
    @Override
    public int getCount() {
        return studentList.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class Viewholder{
        ImageView imghinh;
        TextView txtten,txtstudent_id;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Viewholder holder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(layout,null);
            holder = new Viewholder();
            holder.txtten= (TextView) view.findViewById(R.id.txtten);
            holder.txtstudent_id=(TextView)view.findViewById(R.id.txtmota);
            view.setTag(holder);
        }
        else{
            holder=(Viewholder)view.getTag(i);
        }
        Student std= studentList.get(i);
        holder.txtten.setText(std.getStudent_name());
        holder.txtstudent_id.setText(""+std.getStudent_id());

        return view;
    }
}
