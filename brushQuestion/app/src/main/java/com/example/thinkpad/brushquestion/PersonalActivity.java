package com.example.thinkpad.brushquestion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.List;

public class PersonalActivity extends AppCompatActivity {
    TextView un,nn,sx,bd;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        un = findViewById(R.id.un);
        nn = findViewById(R.id.nn);
        sx = findViewById(R.id.sx);
        bd = findViewById(R.id.bd);
        String usr = getIntent().getExtras().getString("USERNAME");
        List<U_info> info = LitePal.where("username=?", usr).find(U_info.class);
        if (info.size() > 0) {
            un.setText(info.get(0).getUsername());
            nn.setText(info.get(0).getNickname());
            sx.setText(info.get(0).getSex());
            bd.setText(info.get(0).getYear()+"年"+info.get(0).getMonth()+"月"+info.get(0).getDay()+"日");
        }
    }
}
