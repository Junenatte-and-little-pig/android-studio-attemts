package com.example.thinkpad.sendbroadcastreceiver;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.test);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("SEND_SOMETHING");
                intent.setComponent(new ComponentName("com.example.thinkpad.broadcastreceiverdemo","com.example.thinkpad.broadcastreceiverdemo.selfReceiver"));
                sendBroadcast(intent);
            }
        });
    }
}
