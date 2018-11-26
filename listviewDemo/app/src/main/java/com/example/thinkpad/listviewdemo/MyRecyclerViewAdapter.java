package com.example.thinkpad.listviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {
    private List<ItemBean> beanList;
    private LayoutInflater inflater;
    private RecyclerViewListener rvl;

    MyRecyclerViewAdapter(Context context, List<ItemBean> beanList,RecyclerViewListener rvl) {
        this.beanList = beanList;
        inflater = LayoutInflater.from(context);
        this.rvl=rvl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemImage.setImageResource(beanList.get(position).itemImage);
        holder.itemTitle.setText(beanList.get(position).itemTitle);
        holder.itemContent.setText(beanList.get(position).itemContent);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
    @Override
    public void onClick(View v){
        rvl.OnItemClickListener(v,(int)v.getTag());
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView itemImage;
    public TextView itemTitle;
    public TextView itemContent;

    MyViewHolder(View v) {
        super(v);
        itemImage = v.findViewById(R.id.itemImage);
        itemTitle = v.findViewById(R.id.itemTitle);
        itemContent = v.findViewById(R.id.itemContent);
    }
}
