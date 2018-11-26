package com.example.thinkpad.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText userName,passWord;
    Button signUp,signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.userName);
        passWord=findViewById(R.id.passWord);
        signUp=findViewById(R.id.signUp);
        signIn=findViewById(R.id.signIn);
        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String un=userName.getText().toString();
        String pw=passWord.getText().toString();
        int i=v.getId();
        if(R.id.signIn == i){
            if(un.equals("Junenatte")&&pw.equals("junenatte"))
                Toast.makeText(MainActivity.this,"success signing in",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this,"failed in signing in",Toast.LENGTH_LONG).show();
        }
        else if(R.id.signUp == i){
            Bundle bundle=new Bundle();
            bundle.putString("username",un);
            bundle.putString("password",pw);
            Intent sIntent=new Intent(MainActivity.this,signin.class);
            sIntent.putExtras(bundle);
            startActivity(sIntent);
        }
    }
}
