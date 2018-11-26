package com.example.thinkpad.listviewdemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.support.design.widget.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class simpleActivity extends AppCompatActivity {
    ListView simpleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        simpleList=findViewById(R.id.simpleList);
        simpleList.setAdapter(new SimpleAdapter(this,getData(),R.layout.list_item,
                new String[]{"itemImage","itemTitle","itemContent"},
                new int[]{R.id.itemImage,R.id.itemTitle,R.id.itemContent}));
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> hm=(HashMap<String, Object>)(parent.getItemAtPosition(position));
                String str=Objects.requireNonNull(hm.get("itemContent")).toString();
                Snackbar.make(view,str,Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
    }
    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String,Object> map;
        int[] ids={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9};;
        for(int i=0;i<9;i++) {
            map=new HashMap<String,Object>();
            map.put("itemImage", ids[i]);
            map.put("itemTitle", "image"+String.valueOf(i));
            map.put("itemContent", "this is image "+String.valueOf(i));
            list.add(map);
        }
        return list;
    }
}
