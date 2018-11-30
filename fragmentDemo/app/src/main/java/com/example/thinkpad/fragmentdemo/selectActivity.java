package com.example.thinkpad.fragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectActivity extends AppCompatActivity implements View.OnClickListener {
    Button simpleBtn,tabBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        simpleBtn=findViewById(R.id.simpleFragment);
        tabBtn=findViewById(R.id.tabFragment);
        simpleBtn.setOnClickListener(this);
        tabBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        int i=v.getId();
        Intent intent;
        if(R.id.simpleFragment==i){
            intent=new Intent(selectActivity.this,simpleActivity.class);
        }else{
            intent=new Intent(selectActivity.this,tabActivity.class);
        }
        startActivity(intent);
    }
}
