package com.example.thinkpad.brushquestion;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContentPagerAdapter extends PagerAdapter {
    private ArrayList<View> viewList;
    public ContentPagerAdapter(ArrayList<View> viewList) {
        super();
        this.viewList = viewList;
    }
    @Override
    public int getCount() {
        return viewList.size();
    }
    @Override
    public boolean isViewFromObject(View v, Object o) {
        return v == o;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
