package com.example.thinkpad.brushquestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class doworkActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    Button btn_B,btn_C;
    Button submit;
    TextView cal_1,cal_2;
    TextView op;
    EditText result;
    ImageView rw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dowork);
        initView();
    }
    private void initView(){
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);
        btn_0=findViewById(R.id.btn_0);
        btn_B=findViewById(R.id.btn_B);
        btn_C=findViewById(R.id.btn_C);
        submit=findViewById(R.id.submit);
        cal_1=findViewById(R.id.cal_1);
        cal_2=findViewById(R.id.cal_2);
        op=findViewById(R.id.op);
        result=findViewById(R.id.result);
        rw=findViewById(R.id.rw);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_B.setOnClickListener(this);
        btn_C.setOnClickListener(this);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        String str=result.getText().toString();
        switch(v.getId()){
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                str+=((Button)v).getText();
                break;
            case R.id.btn_0:
                if(str!="")
                    str+=((Button)v).getText();
                break;
            case R.id.btn_B:
                if(str!="")
                    str=str.substring(0,str.length()-1);
                else
                    str="";
                break;
            case R.id.btn_C:
                str="";
                break;
            case R.id.submit:
                if(judge(cal_1.getText().toString(),op.getText().toString(),cal_2.getText().toString(),str))
                    rw.setImageResource(R.drawable.right);
                else
                    rw.setImageResource(R.drawable.wrong);
                break;
        }
        result.setText(str);
    }
    public boolean judge(String cal1,String op,String cal2,String result){
        boolean flag=false;
        switch (op){
            case "+":
                if(Integer.parseInt(cal1)+Integer.parseInt(cal2)==Integer.parseInt(result))
                    flag=true;
                break;
            case "-":
                if(Integer.parseInt(cal1)-Integer.parseInt(cal2)==Integer.parseInt(result))
                    flag=true;
                break;
            case "*":
                if(Integer.parseInt(cal1)*Integer.parseInt(cal2)==Integer.parseInt(result))
                    flag=true;
                break;
            case "/":
                if(Integer.parseInt(cal1)/Integer.parseInt(cal2)==Integer.parseInt(result))
                    flag=true;
                break;
        }
        return flag;
    }
}
