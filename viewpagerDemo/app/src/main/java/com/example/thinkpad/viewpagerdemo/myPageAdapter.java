package com.example.thinkpad.viewpagerdemo;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class myPageAdapter extends PagerAdapter {
    private ArrayList<View> viewList;
    private ArrayList<String> titleList;
    myPageAdapter(ArrayList<View> viewList){
        super();
        this.viewList=viewList;
    }
    myPageAdapter(ArrayList<View> viewList, ArrayList<String> titleList){
        super();
        this.viewList=viewList;
        this.titleList=titleList;
    }
    @Override
    public int getCount(){
        return viewList.size();
    }
    @Override
    public boolean isViewFromObject(@NonNull View v, @NonNull Object o){
        return v==o;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        container.addView(viewList.get(position));
        return viewList.get(position);
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView(viewList.get(position));
    }
    @Override
    public CharSequence getPageTitle(int position){
        return titleList.get(position);
    }
}
