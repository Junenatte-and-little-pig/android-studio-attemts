package com.example.thinkpad.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

public class intentServiceActivity extends IntentService {
    public intentServiceActivity() {
        super("intentServiceActivity");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try{
                Thread.sleep(5000);
                System.out.println("service running");
                Toast.makeText(this,"service running",Toast.LENGTH_LONG).show();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"service starting",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        Toast.makeText(this,"service destroying",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
