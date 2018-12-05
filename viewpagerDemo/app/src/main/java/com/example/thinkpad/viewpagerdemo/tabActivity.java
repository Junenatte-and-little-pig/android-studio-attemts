package com.example.thinkpad.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class tabActivity extends AppCompatActivity {
    ViewPager vp_main_tab;
    ArrayList<View> viewList;
    ArrayList<String> titleList;
    myPageAdapter mpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        vp_main_tab=findViewById(R.id.vp_main_tab);
        titleList=new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.main)));
        viewList=new ArrayList<>();
        LayoutInflater li=getLayoutInflater();
        viewList.add(li.inflate(R.layout.view_main_live,null,false));
        viewList.add(li.inflate(R.layout.view_main_recommend,null,false));
        viewList.add(li.inflate(R.layout.view_main_bangumi,null,false));
        mpa=new myPageAdapter(viewList,titleList);
        vp_main_tab.setAdapter(mpa);
        vp_main_tab.setCurrentItem(1);
    }

}
