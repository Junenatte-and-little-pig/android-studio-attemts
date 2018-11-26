package com.example.thinkpad.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectActivity extends AppCompatActivity implements View.OnClickListener {
    Button arrayBtn, simpleBtn, baseBtn, recyclerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        arrayBtn = findViewById(R.id.array);
        simpleBtn = findViewById(R.id.simple);
        baseBtn = findViewById(R.id.base);
        recyclerBtn = findViewById(R.id.recycler);
        arrayBtn.setOnClickListener(this);
        simpleBtn.setOnClickListener(this);
        baseBtn.setOnClickListener(this);
        recyclerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        Intent intent;
        switch (i) {
            case R.id.array:
                intent = new Intent(selectActivity.this, arrayActivity.class);
                break;
            case R.id.simple:
                intent = new Intent(selectActivity.this, simpleActivity.class);
                break;
            case R.id.base:
                intent = new Intent(selectActivity.this, baseActivity.class);
                break;
            case R.id.recycler:
                intent = new Intent(selectActivity.this, recyclerViewActivity.class);
                break;
            default:
                intent = new Intent();
                break;
        }
        startActivity(intent);
    }
}
