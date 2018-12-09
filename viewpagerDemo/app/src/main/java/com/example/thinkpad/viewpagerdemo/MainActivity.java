package com.example.thinkpad.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button simpleVP,titleVP,tabVP,mtVP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleVP=findViewById(R.id.simpleVP);
        titleVP=findViewById(R.id.titleVP);
        tabVP=findViewById(R.id.tabVP);
        mtVP=findViewById(R.id.mySelfTitle);
        simpleVP.setOnClickListener(this);
        titleVP.setOnClickListener(this);
        tabVP.setOnClickListener(this);
        mtVP.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        int i=v.getId();
        Intent intent;
        switch(i){
            case R.id.simpleVP:
                intent=new Intent(MainActivity.this,simpleActivity.class);
                break;
            case R.id.titleVP:
                intent=new Intent(MainActivity.this,titleActivity.class);
                break;
            case R.id.tabVP:
                intent=new Intent(MainActivity.this,tabActivity.class);
                break;
            case R.id.mySelfTitle:
                intent=new Intent(MainActivity.this,mtActivity.class);
                break;
                default:
                    intent=new Intent();
                    break;
        }
        startActivity(intent);
    }
}
