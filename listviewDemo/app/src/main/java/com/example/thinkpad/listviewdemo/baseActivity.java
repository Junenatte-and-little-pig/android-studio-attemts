package com.example.thinkpad.listviewdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class baseActivity extends AppCompatActivity {
    ListView baseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        baseList=findViewById(R.id.baseList);
        List<ItemBean> beanList=new ArrayList<>();
        int[] ids={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9};
        for(int i=0;i<9;i++)
            beanList.add(new ItemBean(ids[i],"Title"+i,"this is image "+i));
        baseList.setAdapter(new MyBaseAdapter(this,beanList));
        baseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemBean bean=(ItemBean)parent.getItemAtPosition(position);
                String str=bean.itemContent;
                Snackbar.make(view,str,Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
