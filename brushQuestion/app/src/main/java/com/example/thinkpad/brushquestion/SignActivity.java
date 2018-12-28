package com.example.thinkpad.brushquestion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SignActivity extends AppCompatActivity {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tabList=new ArrayList<>();
    FragmentManager fm;
    ViewPager signVp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        fm = getSupportFragmentManager();
        initView();
    }

    public void initView() {
        signVp = findViewById(R.id.signVp);
        tabList.add("sign in");
        tabList.add("sign up");
        fragmentList.add(new SignInFragment());
        fragmentList.add(new SignUpFragment());
        signVp.setAdapter(new ContentPagerAdapter(fm, fragmentList,tabList));
        signVp.setCurrentItem(0);
    }
}
