package com.example.thinkpad.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button explicitBtn, implicitBtn, resultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        explicitBtn = findViewById(R.id.explicitIntent);
        implicitBtn = findViewById(R.id.implicitIntent);
        resultBtn = findViewById(R.id.resultIntent);
        explicitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eIntent = new Intent(MainActivity.this, subactivity.class);
                startActivity(eIntent);
            }
        });
        implicitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("data", "test");
                Intent iIntent = new Intent();
                iIntent.setAction(Intent.ACTION_VIEW);
                iIntent.setData(Uri.parse("sjh://a.b.c"));
                iIntent.putExtras(bundle);
                startActivity(iIntent);
            }
        });
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rIntent = new Intent(MainActivity.this, subactivity3.class);
                startActivityForResult(rIntent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Toast.makeText(MainActivity.this, bundle.getString("input"), Toast.LENGTH_LONG).show();
            }
    }
}
