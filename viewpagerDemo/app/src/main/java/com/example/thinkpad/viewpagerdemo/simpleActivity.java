package com.example.thinkpad.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class simpleActivity extends AppCompatActivity {
    ViewPager vp_main;
    ArrayList<View> v_main;
    myPageAdapter mpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        vp_main=findViewById(R.id.vp_main);
        v_main=new ArrayList<View>();
        LayoutInflater li=getLayoutInflater();
        v_main.add(li.inflate(R.layout.view_main_live,null,false));
        v_main.add(li.inflate(R.layout.view_main_recommend,null,false));
        v_main.add(li.inflate(R.layout.view_main_bangumi,null,false));
        mpa=new myPageAdapter(v_main);
        vp_main.setAdapter(mpa);
        vp_main.setCurrentItem(1);
    }
}
