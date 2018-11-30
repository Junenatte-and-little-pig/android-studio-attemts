package com.example.thinkpad.dialogdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button tripleDialog,listDialog,singleDialog,multiDialog,waitDialog,progressDialog,editDialog,selfDialog;
    int choice;
    ArrayList<Integer> choices=new ArrayList<Integer>();
    String[] data={"test1","test2","test3","test4"};
    Intent pIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tripleDialog=findViewById(R.id.tripleDialog);
        listDialog=findViewById(R.id.listDialog);
        singleDialog=findViewById(R.id.singleDialog);
        multiDialog=findViewById(R.id.multiDialog);
        waitDialog=findViewById(R.id.waitDialog);
        progressDialog=findViewById(R.id.progressDialog);
        editDialog=findViewById(R.id.editDialog);
        selfDialog=findViewById(R.id.selfDialog);
        tripleDialog.setOnClickListener(this);
        listDialog.setOnClickListener(this);
        singleDialog.setOnClickListener(this);
        multiDialog.setOnClickListener(this);
        waitDialog.setOnClickListener(this);
        progressDialog.setOnClickListener(this);
        editDialog.setOnClickListener(this);
        selfDialog.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        int i=v.getId();
        choice=-1;
        switch(i){
            case R.id.tripleDialog:
                AlertDialog.Builder triple=new AlertDialog.Builder(MainActivity.this);
                triple.setIcon(R.drawable.ic_launcher_foreground).setTitle("triple").setMessage("this is a triple");
                triple.setPositiveButton("hello", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG).show();
                    }
                }).setNeutralButton("hehe", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"hehe",Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("bye", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"bye",Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            case R.id.listDialog:
                AlertDialog.Builder list=new AlertDialog.Builder(MainActivity.this);
                list.setIcon(R.drawable.ic_launcher_foreground).setTitle("list").setItems(data, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"press on "+data[which],Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            case R.id.singleDialog:
                AlertDialog.Builder single=new AlertDialog.Builder(MainActivity.this);
                single.setIcon(R.drawable.ic_launcher_foreground).setTitle("single").setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice=which;
                    }
                }).setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(-1 != choice)
                            Toast.makeText(MainActivity.this,"choose on "+data[choice],Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            case R.id.multiDialog:
                final boolean[] init={false,false,false,false};
                AlertDialog.Builder multi=new AlertDialog.Builder(MainActivity.this);
                multi.setIcon(R.drawable.ic_launcher_foreground).setTitle("multi").setMultiChoiceItems(data, init, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked)
                            choices.add(which);
                        else
                            choices.remove(which);
                    }
                }).setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str="";
                        for(int i=0;i<choices.size();i++)
                            str+=data[choices.get(i)]+" ";
                        Toast.makeText(MainActivity.this,"ur choices are "+str,Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            case R.id.waitDialog:
                Bundle wBundle=new Bundle();
                wBundle.putBoolean("waitOrProgress",true);
                pIntent=new Intent(MainActivity.this,progressActivity.class);
                pIntent.putExtras(wBundle);
                startActivity(pIntent);
                break;
            case R.id.progressDialog:
                Bundle pBundle=new Bundle();
                pBundle.putBoolean("waitOrProgress",false);
                pIntent=new Intent(MainActivity.this,progressActivity.class);
                pIntent.putExtras(pBundle);
                startActivity(pIntent);
                break;
            case R.id.editDialog:
                final EditText et=new EditText(MainActivity.this);
                AlertDialog.Builder edit=new AlertDialog.Builder(MainActivity.this);
                edit.setIcon(R.drawable.ic_launcher_foreground).setTitle("edit").setView(et).setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,et.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            case R.id.selfDialog:
                final View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog,null);
                AlertDialog.Builder self=new AlertDialog.Builder(MainActivity.this);
                self.setIcon(R.drawable.ic_launcher_foreground).setView(view).setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str=((EditText)view.findViewById(R.id.username)).getText().toString()+
                                ((EditText)view.findViewById(R.id.password)).getText().toString();
                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
            default:
                break;
        }
    }
}
