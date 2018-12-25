package com.example.thinkpad.brushquestion;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.app.Activity.RESULT_OK;

public class SignInFragment extends Fragment {
    View SignInFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(SignInFragment==null)
            SignInFragment=inflater.inflate(R.layout.fragment_signin,null);
        final EditText i_u,i_p;
        Button i_c;
        i_u=SignInFragment.findViewById(R.id.signin_username);
        i_p=SignInFragment.findViewById(R.id.signin_password);
        i_c=SignInFragment.findViewById(R.id.signin_confirm);
        i_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                if(findUsr(i_u.getText().toString())) {
                    if (checkPsw(i_p.getText().toString())) {
                        //登陆成功
                        bundle.putBoolean("IS_LOGIN",true);
                        bundle.putString("USERNAME",i_u.getText().toString());
                    } else {//登录失败
                        bundle.putBoolean("IS_LOGIN",false);
                    }
                }
                intent.putExtras(bundle);
                getActivity().setResult(RESULT_OK,intent);
                getActivity().finish();
            }
        });
        return SignInFragment;
    }
    public boolean findUsr(String usr){
        boolean flag=false;
        //if在数据库中查找到usr
        //flag=true;
        if(usr.equals("junenatte"))
            flag=true;
        return flag;
    }
    public boolean checkPsw(String pwd){
        boolean flag=false;
        //if在数据库中查找到usr对应的pwd
        //flag=true;
        if(pwd.equals("junenatte"))
            flag=true;
        return flag;
    }
}
