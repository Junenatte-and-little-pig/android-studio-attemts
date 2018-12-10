package com.example.thinkpad.broadcastreceiverdemo;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()==Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Bundle b = intent.getExtras();
            Object o=b.get("state");
            switch (o.toString()){
                case "false":
                    Toast.makeText(context, "飞行模式已关闭", Toast.LENGTH_LONG).show();
                    break;
                case "true":
                    Toast.makeText(context, "飞行模式已开启", Toast.LENGTH_LONG).show();
                    break;
            }
        }else if(intent.getAction()=="android.bluetooth.adapter.action.STATE_CHANGED"){
            int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch (state) {
                case BluetoothAdapter.STATE_ON:
                    Toast.makeText(context, "蓝牙已开启", Toast.LENGTH_LONG).show();
                    break;
                case BluetoothAdapter.STATE_OFF:
                    Toast.makeText(context, "蓝牙已关闭", Toast.LENGTH_LONG).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    Toast.makeText(context, "蓝牙正在开启", Toast.LENGTH_LONG).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    Toast.makeText(context, "蓝牙正在关闭", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
