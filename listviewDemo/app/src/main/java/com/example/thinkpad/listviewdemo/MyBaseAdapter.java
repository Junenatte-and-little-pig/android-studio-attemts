package com.example.thinkpad.listviewdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private List<ItemBean> beanList;
    private LayoutInflater inflater;
    MyBaseAdapter(Context context, List<ItemBean> beanList){
        this.beanList=beanList;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount(){
        return beanList.size();
    }
    @Override
    public Object getItem(int position){
        return beanList.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.list_item,null);
            viewHolder.itemImage=convertView.findViewById(R.id.itemImage);
            viewHolder.itemTitle=convertView.findViewById(R.id.itemTitle);
            viewHolder.itemContent=convertView.findViewById(R.id.itemContent);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        ItemBean bean=beanList.get(position);
        viewHolder.itemImage.setImageResource(bean.itemImage);
        viewHolder.itemTitle.setText(bean.itemTitle);
        viewHolder.itemContent.setText(bean.itemContent);
        return convertView;
    }
}
