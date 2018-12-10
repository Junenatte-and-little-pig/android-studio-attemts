package com.example.thinkpad.broadcastreceiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyReceiver mbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbr=new MyReceiver();
        IntentFilter iFilter=new IntentFilter();
        iFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        iFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(mbr,iFilter);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(mbr);
    }
}
