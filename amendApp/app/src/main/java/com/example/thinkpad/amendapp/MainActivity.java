package com.example.thinkpad.amendapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button amend;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amend=findViewById(R.id.amend);
        amend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                switch(count){
                    case 0:
                        amend.setText("点我");
                        break;
                    case 1:
                        amend.setText("再点一下嘛~");
                        break;
                    case 2:
                        amend.setText("还有……");
                        AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
                        ab.setIcon(R.drawable.ic_launcher_foreground).setTitle("夫人对不起").setMessage("你的笨先生真的知道错了").setPositiveButton("知道了下一个",null).show();
                        break;
                    case 3:
                        amend.setText("爱你");
                        AlertDialog.Builder abb=new AlertDialog.Builder(MainActivity.this);
                        abb.setIcon(R.drawable.ic_launcher_foreground).setTitle("原谅我一哈哈嘛").setMessage("好不好嘛夫人，夫人最好了对不对").setPositiveButton("哦",null).show();
                        break;
                    case 4:
                        count=0;
                        amend.setText("点我");
                        Intent intent=new Intent(MainActivity.this,amendActivity.class);
                        startActivity(intent);
                        break;
                        default:
                            break;
                }
            }
        });
    }
}
