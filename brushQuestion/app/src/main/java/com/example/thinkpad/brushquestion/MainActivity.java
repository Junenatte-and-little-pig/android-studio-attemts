package com.example.thinkpad.brushquestion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private ViewPager contentVp;
    FragmentManager fm;
    Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getSupportFragmentManager();
        initView();
    }
    @SuppressLint("InflateParams")
    private void initView(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        contentVp=findViewById(R.id.mainPage);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new DoworkFragment());
        fragmentList.add(new ReviewFragment());
        fragmentList.add(new ExtensionFragment());
        contentVp.setAdapter(new ContentPagerAdapter(fm,fragmentList));
        contentVp.setCurrentItem(0);

        ImageButton ib_dowork = findViewById(R.id.ib_dowork);
        ImageButton ib_review = findViewById(R.id.ib_review);
        ImageButton ib_extension = findViewById(R.id.ib_extension);
        Button tb_dowork = findViewById(R.id.tb_dowork);
        Button tb_review = findViewById(R.id.tb_review);
        Button tb_extension = findViewById(R.id.tb_extension);
        ib_dowork.setOnClickListener(this);
        ib_review.setOnClickListener(this);
        ib_extension.setOnClickListener(this);
        tb_dowork.setOnClickListener(this);
        tb_review.setOnClickListener(this);
        tb_extension.setOnClickListener(this);

        View header=navigationView.getHeaderView(0);
        sign=header.findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,SignActivity.class);
                startActivityForResult(intent,1);
            }
        });
        EditText briefing=header.findViewById(R.id.usr_briefing);
        briefing.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    assert imm != null;
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                boolean isLogin = bundle.getBoolean("IS_LOGIN");
                if (isLogin) {
                    sign.setText(bundle.getString("USERNAME"));
                    sign.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Snackbar.make(findViewById(R.id.drawer_layout),"您已登陆",Snackbar.LENGTH_LONG).show();
                        }
                    });
                }
            }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.ib_dowork:
            case R.id.tb_dowork:
                contentVp.setCurrentItem(0);
                break;
            case R.id.ib_review:
            case R.id.tb_review:
                contentVp.setCurrentItem(1);
                break;
            case R.id.ib_extension:
            case R.id.tb_extension:
                contentVp.setCurrentItem(2);
                break;
        }
    }
}
