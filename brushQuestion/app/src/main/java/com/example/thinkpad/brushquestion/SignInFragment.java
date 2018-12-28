package com.example.thinkpad.brushquestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class SignInFragment extends Fragment {
    View SignInFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (SignInFragment == null)
            SignInFragment = inflater.inflate(R.layout.fragment_signin, null);
        final EditText i_u, i_p;
        Button i_c;
        i_u = SignInFragment.findViewById(R.id.signin_username);
        i_p = SignInFragment.findViewById(R.id.signin_password);
        i_c = SignInFragment.findViewById(R.id.signin_confirm);
        i_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                String u=i_u.getText().toString();
                String p=i_p.getText().toString();
                if (findUsr(u)) {
                    if (checkPsw(u,p)) {
                        //登陆成功
                        bundle.putBoolean("IS_LOGIN", true);
                        bundle.putString("USERNAME", u);
                        intent.putExtras(bundle);
                        getActivity().setResult(RESULT_OK, intent);
                        getActivity().finish();
                    } else {//登录失败
                        bundle.putBoolean("IS_LOGIN", false);
                        Toast.makeText(getContext(),"密码错误",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return SignInFragment;
    }

    public boolean findUsr(String usr) {
        boolean flag = false;
        List<UP> up = LitePal.where("username=?",usr).find(UP.class);
        if (up.size()>0)
            if (up.get(0).getUsername().equals(usr))
                flag = true;
        return flag;
    }

    public boolean checkPsw(String usr,String pwd) {
        boolean flag = false;
        List<UP> up = LitePal.select("password").where("username=?",usr).find(UP.class);
        if (up.size()>0)
            if (up.get(0).getPassword().equals(pwd))
                flag = true;
        return flag;
    }
}
