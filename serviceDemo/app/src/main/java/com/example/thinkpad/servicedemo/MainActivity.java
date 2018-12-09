package com.example.thinkpad.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startFirst,endFirst,startSecond,endSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        startFirst=findViewById(R.id.startFirst);
        endFirst=findViewById(R.id.endFirst);
        startSecond=findViewById(R.id.startSecond);
        endSecond=findViewById(R.id.endSecond);
        startFirst.setOnClickListener(this);
        endFirst.setOnClickListener(this);
        startSecond.setOnClickListener(this);
        endSecond.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.startFirst:
                i=new Intent(MainActivity.this,serviceActivity.class);
                startService(i);
                break;
            case R.id.endFirst:
                i=new Intent(MainActivity.this,serviceActivity.class);
                stopService(i);
                break;
            case R.id.startSecond:
                i=new Intent(MainActivity.this,intentServiceActivity.class);
                startService(i);
                break;
            case R.id.endSecond:
                i=new Intent(MainActivity.this,intentServiceActivity.class);
                stopService(i);
                break;
        }
    }
}
