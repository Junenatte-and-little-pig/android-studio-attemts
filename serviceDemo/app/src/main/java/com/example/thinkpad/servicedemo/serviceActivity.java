package com.example.thinkpad.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

public class serviceActivity extends Service {
    private ServiceHandler serviceHandler;
    private Looper serviceLooper;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    @Override
    public void onCreate() {
        HandlerThread thread = new HandlerThread("ServiceStartArguments",Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Message msg = serviceHandler.obtainMessage();
        msg.arg1 = startId;
        serviceHandler.sendMessage(msg);
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
