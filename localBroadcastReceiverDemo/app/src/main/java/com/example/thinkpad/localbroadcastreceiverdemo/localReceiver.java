package com.example.thinkpad.localbroadcastreceiverdemo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Objects;

public class localReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        ActivityController.finishAll();
        Intent login = new Intent(context, LoginActivity.class);
        Toast.makeText(context, intent.getAction().toString(), Toast.LENGTH_LONG).show();
        login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(login);
    }
}
