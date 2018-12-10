package com.example.thinkpad.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class selfReceiver extends BroadcastReceiver {
    private final String TEST_ACTION="SEND_SOMETHING";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(TEST_ACTION.equals(intent.getAction()))
            Toast.makeText(context,"hhhhhhhhhhhhhhhhhhhhh",Toast.LENGTH_LONG).show();
    }
}
