package com.example.thinkpad.brushquestion;

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

public class SignUpFragment extends Fragment {
    View SignUpFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(SignUpFragment==null)
            SignUpFragment=inflater.inflate(R.layout.fragment_signup,null);
        final EditText u_u,u_p,u_cp;
        Button u_c;
        u_u=SignUpFragment.findViewById(R.id.signup_uaername);
        u_p=SignUpFragment.findViewById(R.id.signup_password);
        u_cp=SignUpFragment.findViewById(R.id.confirm_password);
        u_c=SignUpFragment.findViewById(R.id.signup_confirm);
        u_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!findUsr(u_u.getText().toString())) {
                    if (u_p.getText().toString().equals(u_cp.getText().toString())) {//往数据库里添加账号密码信息
                    }else{
                        Toast.makeText(getContext(),"两次密码不一致",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getContext(),"用户名已存在",Toast.LENGTH_LONG).show();
                }
            }
        });
        return SignUpFragment;
    }
    public boolean findUsr(String usr){
        boolean flag=false;
        //if在数据库中查找到usr
        //flag=true;
        return flag;
    }
}
