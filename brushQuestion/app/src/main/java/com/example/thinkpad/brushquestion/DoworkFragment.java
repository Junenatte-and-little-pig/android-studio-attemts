package com.example.thinkpad.brushquestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DoworkFragment extends Fragment {
    View DoworkView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(DoworkView==null)
            DoworkView=inflater.inflate(R.layout.fragment_dowork,null);
        DoworkView.findViewById(R.id.startBrush).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),doworkActivity.class);
                startActivity(intent);
            }
        });
        return DoworkView;
    }
}
