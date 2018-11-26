package com.example.thinkpad.intentdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class startpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent sIntent=new Intent(startpage.this,MainActivity.class);
                startActivity(sIntent);
                finish();
            }
        },3000);
    }
}
