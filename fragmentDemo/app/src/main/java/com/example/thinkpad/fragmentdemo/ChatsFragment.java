package com.example.thinkpad.fragmentdemo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChatsFragment extends Fragment {
    ListView chatsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chats, container, false);
        chatsList=view.findViewById(R.id.chatsList);
        chatsList.setAdapter(new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.news_category)));
        return view;
    }
}
