package com.example.thinkpad.listviewdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class recyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        final List<ItemBean> beanList = new ArrayList<>();
        int[] ids = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9};
        for (int i = 0; i < 9; i++)
            beanList.add(new ItemBean(ids[i], "Title" + i, "this is image " + i));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewListener rvl = new RecyclerViewListener() {
            @Override
            public void OnItemClickListener(View v, int position) {
                ItemBean bean = beanList.get(position);
                String str=bean.itemContent;
                Snackbar.make(v, str, Snackbar.LENGTH_LONG).show();
            }
        };
        recyclerView.setAdapter(new MyRecyclerViewAdapter(this, beanList, rvl));
    }
}
