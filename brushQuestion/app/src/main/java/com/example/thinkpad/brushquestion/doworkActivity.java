package com.example.thinkpad.brushquestion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.Inflater;

public class doworkActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_B, btn_C;
    Button submit;
    TextView cal_1, cal_2;
    TextView op;
    TextView totalTime, showTime;
    EditText result;
    ImageView rw;
    Timer countTime, countDownTime;
    TimerTask tt_ct, tt_cdt;
    Handler handler;
    static final int COUNT_MESSAGE = 0;
    static final int COUNT_DOWN_MESSAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dowork);
        initView();
        startTimer(countTime, tt_ct, COUNT_MESSAGE);
    }

    @SuppressLint("HandlerLeak")
    private void initView() {
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        btn_B = findViewById(R.id.btn_B);
        btn_C = findViewById(R.id.btn_C);
        submit = findViewById(R.id.submit);
        cal_1 = findViewById(R.id.cal_1);
        cal_2 = findViewById(R.id.cal_2);
        op = findViewById(R.id.op);
        totalTime = findViewById(R.id.totalTime);
        totalTime.setText("0");
        showTime = findViewById(R.id.showTime);
        result = findViewById(R.id.result);
        rw = findViewById(R.id.rw);
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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime.setText("3");
                if (!result.getText().toString().equals(""))
                    if (judge(cal_1.getText().toString(), op.getText().toString(), cal_2.getText().toString(), result.getText().toString()))
                        rw.setImageResource(R.drawable.right);
                    else {
                        rw.setImageResource(R.drawable.wrong);
                        List<U_info> info=LitePal.where("nickname=?","abc").find(U_info.class);
                        List<U_qs> qs=LitePal.where("username=?",info.get(0).getUsername()).find(U_qs.class);
                        qs.get(0).setWrongs(cal_1.getText().toString()+" "+op.getText().toString()+" "+ cal_2.getText().toString());
                        qs.get(0).updateAll("username=?",info.get(0).getUsername());
                    }
                startTimer(countDownTime, tt_cdt, COUNT_DOWN_MESSAGE);
            }
        });
        nextQ();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case COUNT_MESSAGE:
                        int tt = Integer.parseInt(totalTime.getText().toString());
                        totalTime.setText(String.valueOf(tt + 1));
                        break;
                    case COUNT_DOWN_MESSAGE:
                        if (!showTime.getText().toString().equals("")) {
                            int st = Integer.parseInt(showTime.getText().toString());
                            if (st == 0) {
                                nextQ();
                            } else
                                showTime.setText(String.valueOf(st - 1));
                        }
                        break;
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        String str = result.getText().toString();
        switch (v.getId()) {
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                if (!str.equals("0"))
                    str += ((Button) v).getText();
                else
                    str = ((Button) v).getText().toString();
                break;
            case R.id.btn_0:
                if (!str.equals("0"))
                    str += ((Button) v).getText();
                break;
            case R.id.btn_B:
                if (!str.equals(""))
                    str = str.substring(0, str.length() - 1);
                else
                    str = "";
                break;
            case R.id.btn_C:
                str = "";
                break;
        }
        result.setText(str);
    }

    public boolean judge(String cal1, String op, String cal2, String result) {
        boolean flag = false;
        switch (op) {
            case "+":
                if (Integer.parseInt(cal1) + Integer.parseInt(cal2) == Integer.parseInt(result))
                    flag = true;
                break;
            case "-":
                if (Integer.parseInt(cal1) - Integer.parseInt(cal2) == Integer.parseInt(result))
                    flag = true;
                break;
            case "*":
                if (Integer.parseInt(cal1) * Integer.parseInt(cal2) == Integer.parseInt(result))
                    flag = true;
                break;
            case "/":
                if (Integer.parseInt(cal1) / Integer.parseInt(cal2) == Integer.parseInt(result))
                    flag = true;
                break;
        }
        return flag;
    }

    public void startTimer(Timer timer, TimerTask timerTask, final int msg) {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                sendMessage(msg);
            }
        };
        if (msg == COUNT_DOWN_MESSAGE) {
            if (!showTime.getText().toString().equals(""))
                if (Integer.parseInt(showTime.getText().toString()) > 0)
                    timer.schedule(timerTask, 0, 1000);
        } else
            timer.schedule(timerTask, 0, 1000);
    }

    public void stopTimer(Timer timer, TimerTask timerTask) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    public void sendMessage(int id) {
        if (handler != null) {
            Message msg = Message.obtain(handler, id);
            handler.sendMessage(msg);
        }
    }

    public void nextQ() {
        Random random = new Random();
        cal_1.setText(String.valueOf(random.nextInt() % 100));
        cal_2.setText(String.valueOf(random.nextInt() % 100));
        switch (random.nextInt() % 4) {
            case 0:
                op.setText("+");
                break;
            case 1:
                op.setText("-");
                break;
            case 2:
                op.setText("*");
                break;
            case 3:
                op.setText("/");
                break;
        }
        showTime.setText("");
        result.setText("");
        rw.setImageDrawable(null);
    }
}
