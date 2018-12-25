package com.example.thinkpad.brushquestion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private ViewPager contentVp;
    FragmentManager fm;
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
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
    public boolean onNavigationItemSelected(MenuItem item) {
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
                Toast.makeText(this,"0",Toast.LENGTH_LONG).show();
                break;
            case R.id.ib_review:
            case R.id.tb_review:
                contentVp.setCurrentItem(1);
                Toast.makeText(this,"1",Toast.LENGTH_LONG).show();
                break;
            case R.id.ib_extension:
            case R.id.tb_extension:
                contentVp.setCurrentItem(2);
                Toast.makeText(this,"2",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
