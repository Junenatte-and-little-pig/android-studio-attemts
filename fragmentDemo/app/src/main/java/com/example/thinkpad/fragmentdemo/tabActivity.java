package com.example.thinkpad.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class tabActivity extends FragmentActivity implements View.OnClickListener {
    private RadioButton rb_chats, rb_contacts, rb_discover, rb_me;
    private RadioGroup rg;
    private Fragment f_chats,f_contacts,f_discover,f_me;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        rb_chats=findViewById(R.id.chats);
        rb_contacts=findViewById(R.id.contacts);
        rb_discover=findViewById(R.id.discover);
        rb_me=findViewById(R.id.me);
        rg=findViewById(R.id.radioGroup);
        rb_chats.setOnClickListener(this);
        rb_contacts.setOnClickListener(this);
        rb_discover.setOnClickListener(this);
        rb_me.setOnClickListener(this);
        rg.check(R.id.chats);
        f_chats=new ChatsFragment();
        ft.replace(R.id.frameFragment,f_chats);
        ft.commit();
    }
    @Override
    public void onClick(View v){
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        int i=v.getId();
        switch(i){
            case R.id.chats:
                hideFragment(ft);
                f_chats=new ChatsFragment();
                ft.replace(R.id.frameFragment,f_chats);
                ft.commit();
                break;
            case R.id.contacts:
                hideFragment(ft);
                f_contacts=new ContactsFragment();
                ft.replace(R.id.frameFragment,f_contacts);
                ft.commit();
                break;
            case R.id.discover:
                hideFragment(ft);
                f_discover=new DiscoverFragment();
                ft.replace(R.id.frameFragment,f_discover);
                ft.commit();
                break;
            case R.id.me:
                hideFragment(ft);
                f_me=new MeFragment();
                ft.replace(R.id.frameFragment,f_me);
                ft.commit();
                break;
            default:
                    break;
        }
    }
    private void hideFragment(FragmentTransaction ft){
        if(f_chats!=null)
            ft.remove(f_chats);
        if(f_contacts!=null)
            ft.remove(f_contacts);
        if(f_discover!=null)
            ft.remove(f_discover);
        if(f_me!=null)
            ft.remove(f_me);
    }
}
