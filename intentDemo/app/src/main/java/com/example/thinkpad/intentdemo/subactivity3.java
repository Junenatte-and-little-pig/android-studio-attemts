package com.example.thinkpad.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class subactivity3 extends AppCompatActivity {
EditText textInput;
Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity3);
        textInput=findViewById(R.id.testInput);
        backBtn=findViewById(R.id.testBack);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String str=textInput.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("input",str);
                Intent bIntent=new Intent();
                bIntent.putExtras(bundle);
                setResult(RESULT_OK,bIntent);
                finish();
            }
        });
    }
}
