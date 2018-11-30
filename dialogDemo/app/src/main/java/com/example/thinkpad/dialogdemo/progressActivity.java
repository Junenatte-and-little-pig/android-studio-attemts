package com.example.thinkpad.dialogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class progressActivity extends AppCompatActivity {
    ProgressBar wait,progress;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        wait=findViewById(R.id.wait);
        progress=findViewById(R.id.progress);
        bundle=this.getIntent().getExtras();
        boolean wop=bundle.getBoolean("waitOrProgress");
        if(wop){
            wait.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }else{
            progress.setVisibility(View.VISIBLE);
            wait.setVisibility(View.GONE);
            progress.setMax(100);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i= 0;
                    while (i < 100){
                        try {
                            Thread.sleep(100);
                            i++;
                            progress.setProgress(i);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
