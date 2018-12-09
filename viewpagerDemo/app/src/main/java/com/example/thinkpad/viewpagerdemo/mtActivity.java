package com.example.thinkpad.viewpagerdemo;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mtActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager mtVP;
    private ImageView cursor;
    private TextView tv_live, tv_recommend, tv_bangumi;
    private ArrayList<View> viewList;
    private int offset = 0;
    private int currentIndex = 1;
    private int bmpWidth = 0;
    private int one = 0, two = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mt);
        initView();
    }

    private void initView() {
        mtVP = findViewById(R.id.mtVP);
        tv_live = findViewById(R.id.live);
        tv_recommend = findViewById(R.id.recommend);
        tv_bangumi = findViewById(R.id.bangumi);
        cursor = findViewById(R.id.cursor);
        bmpWidth = BitmapFactory.decodeResource(getResources(), R.drawable.line).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int sreenW = dm.widthPixels;
        offset = (sreenW / 3 - bmpWidth) / 2;
        one = offset * 3 + bmpWidth;
        two = offset * 5 + bmpWidth * 2;
        viewList = new ArrayList<>();
        LayoutInflater li = getLayoutInflater();
        viewList.add(li.inflate(R.layout.view_main_live, null, false));
        viewList.add(li.inflate(R.layout.view_main_recommend, null, false));
        viewList.add(li.inflate(R.layout.view_main_bangumi, null, false));
        mtVP.setAdapter(new myPageAdapter(viewList));
        mtVP.setCurrentItem(1);
        tv_live.setOnClickListener(this);
        tv_recommend.setOnClickListener(this);
        tv_bangumi.setOnClickListener(this);
        mtVP.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.live:
                mtVP.setCurrentItem(0);
                break;
            case R.id.recommend:
                mtVP.setCurrentItem(1);
                break;
            case R.id.bangumi:
                mtVP.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageSelected(int index) {
        Animation animation = null;
        switch (index) {
            case 0:
                if (currentIndex == 1)
                    animation = new TranslateAnimation(0, -one, 0, 0);
                else if (currentIndex == 2)
                    animation = new TranslateAnimation(one, -one, 0, 0);
                break;
            case 1:
                if (currentIndex == 0)
                    animation = new TranslateAnimation(-one, 0, 0, 0);
                else if (currentIndex == 2)
                    animation = new TranslateAnimation(one, 0, 0, 0);
                break;
            case 2:
                if (currentIndex == 0)
                    animation = new TranslateAnimation(-one, one, 0, 0);
                else if (currentIndex == 1)
                    animation = new TranslateAnimation(0, one, 0, 0);
                break;
        }
        currentIndex = index;
        if (animation != null) {
            animation.setFillAfter(true);
            animation.setDuration(300);
        }
        cursor.startAnimation(animation);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }

    @Override
    public void onPageScrolled(int i, float f, int i1) {
    }
}
