package com.example.thinkpad.localbroadcastreceiverdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
