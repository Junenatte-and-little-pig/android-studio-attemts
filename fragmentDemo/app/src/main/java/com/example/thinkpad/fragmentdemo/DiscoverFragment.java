package com.example.thinkpad.fragmentdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DiscoverFragment extends Fragment implements View.OnClickListener {
    Button moments,game,miniProgram;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_discover, container, false);
        moments=view.findViewById(R.id.moments);
        game=view.findViewById(R.id.game);
        miniProgram=view.findViewById(R.id.mini_program);
        moments.setOnClickListener(this);
        game.setOnClickListener(this);
        miniProgram.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v){
        int i=v.getId();
        switch (i) {
            case R.id.moments:
                Toast.makeText(v.getContext(), "moments", Toast.LENGTH_LONG).show();
                break;
            case R.id.game:
                Toast.makeText(v.getContext(), "game", Toast.LENGTH_LONG).show();
                break;
            case R.id.mini_program:
                Toast.makeText(v.getContext(), "mini_program", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
