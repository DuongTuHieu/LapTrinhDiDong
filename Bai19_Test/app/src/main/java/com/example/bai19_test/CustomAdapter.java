package com.example.bai19_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater=null;//Thổi cái giao diện vào trong cái màn hình
    ArrayList<Hieu> hieu=new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<Hieu> hieu) {//Vì ở dưới kia gọi rồi
        this.context = context;
        this.hieu = hieu;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hieu.size();
    }

    @Override
    public Object getItem(int position) {
        return hieu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.hieu, parent, false);
        }
        ImageView hinh=(ImageView) convertView.findViewById(R.id.img);
        TextView tvT=(TextView) convertView.findViewById(R.id.nd);
        //
        tvT.setText(hieu.get(position).name);
        hinh.setImageResource(hieu.get(position).avt);
        return convertView;
    }
}
