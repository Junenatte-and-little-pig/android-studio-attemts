package com.example.thinkpad.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ContentFragment extends Fragment {
    ListView testList;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_content, container, false);
        testList=view.findViewById(R.id.testList);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.news_category));
        testList.setAdapter(adapter);
        return view;
    }
}
