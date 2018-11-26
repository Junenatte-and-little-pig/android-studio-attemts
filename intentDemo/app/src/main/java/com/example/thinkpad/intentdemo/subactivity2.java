package com.example.thinkpad.intentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class subactivity2 extends AppCompatActivity {
    TextView testText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity2);
        testText=findViewById(R.id.testText);
        Bundle bundle=this.getIntent().getExtras();
        String result=bundle.getString("data");
        testText.setText(result);
    }
}
