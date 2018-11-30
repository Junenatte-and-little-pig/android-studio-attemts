package com.example.thinkpad.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TitleFragment extends Fragment {
    Button testBtn;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_title,container,false);
        testBtn=view.findViewById(R.id.testBtn);
        testBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(),"hhhhhhhhhhhh",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
