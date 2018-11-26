package com.example.thinkpad.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class arrayActivity extends AppCompatActivity {
    ListView arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        arrayList=findViewById(R.id.arrayList);
        arrayList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.news_category)));
        arrayList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v,int pos,long id){
                String str=parent.getItemAtPosition(pos).toString();
                Toast.makeText(arrayActivity.this,str,Toast.LENGTH_LONG).show();
            }
        });
    }
}
