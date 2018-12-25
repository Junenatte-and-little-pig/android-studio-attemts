package com.example.thinkpad.brushquestion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ContentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> tabList;
    ContentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList){
        super(fm);
        this.fragmentList=fragmentList;
    }
    ContentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> tabList){
        super(fm);
        this.fragmentList=fragmentList;
        this.tabList=tabList;
    }
    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList!=null?fragmentList.size():0;
    }
    @Override
    public CharSequence getPageTitle(int position){
        return tabList.get(position);
    }
}
