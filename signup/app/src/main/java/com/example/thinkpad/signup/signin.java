package com.example.thinkpad.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class signin extends AppCompatActivity {
    TextView signinShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        signinShow=findViewById(R.id.signinShow);
        Bundle receive=this.getIntent().getExtras();
        String un=receive.getString("username");
        String pw=receive.getString("password");
        signinShow.setText("username: "+un+"\npassword: "+pw+"\nsign up success!");
    }
}
