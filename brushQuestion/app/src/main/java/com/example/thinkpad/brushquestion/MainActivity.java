package com.example.thinkpad.brushquestion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private ViewPager contentVp;
    private ArrayList<View> viewList;
    private ImageButton ib_dowork,ib_review,ib_extension;
    private Button tb_dowork,tb_review,tb_extension;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        toolbar=findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        contentVp=findViewById(R.id.mainPage);
        viewList=new ArrayList<>();
        LayoutInflater li=getLayoutInflater();
        viewList.add(li.inflate(R.layout.dowork,null,false));
        viewList.add(li.inflate(R.layout.review,null,false));
        viewList.add(li.inflate(R.layout.extension,null,false));
        contentVp.setAdapter(new ContentPagerAdapter(viewList));
        contentVp.setCurrentItem(0);

        ib_dowork=findViewById(R.id.ib_dowork);
        ib_review=findViewById(R.id.ib_review);
        ib_extension=findViewById(R.id.ib_extension);
        tb_dowork=findViewById(R.id.tb_dowork);
        tb_review=findViewById(R.id.tb_review);
        tb_extension=findViewById(R.id.tb_extension);
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
