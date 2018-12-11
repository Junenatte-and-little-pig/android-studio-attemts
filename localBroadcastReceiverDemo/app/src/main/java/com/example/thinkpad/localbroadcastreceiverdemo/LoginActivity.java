package com.example.thinkpad.localbroadcastreceiverdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor spe;
    private EditText username,password;
    private Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp=PreferenceManager.getDefaultSharedPreferences(this);
        initView();
    }
    private void initView() {
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirm=findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = username.getText().toString();
                String pw = password.getText().toString();
                if (un.equals("aaa") && pw.equals("bbb")) {
                    spe=sp.edit();
                    spe.putString("un",un);
                    spe.putString("pw",pw);
                    spe.apply();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                    finish();
                }else{Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();}
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(!sp.getString("un","").equals("")){
            username.setText(sp.getString("un",""));
            password.setText(sp.getString("pw",""));
        }
    }
}
