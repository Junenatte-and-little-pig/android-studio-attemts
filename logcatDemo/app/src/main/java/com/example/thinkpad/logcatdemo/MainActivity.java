package com.example.thinkpad.logcatdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
private static String TAG="ACTIVITYLIFE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"--(1)OnCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"--(9)OnDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"--(2)OnStop");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"--(8)OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"--(6)OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"--(4)OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"--(7)OnPause");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"--(3)OnRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"--(5)OnSaveInstanceState");
    }
}
