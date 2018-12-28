package com.example.thinkpad.brushquestion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class SignUpFragment extends Fragment {
    View SignUpFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (SignUpFragment == null)
            SignUpFragment = inflater.inflate(R.layout.fragment_signup, null);
        final EditText u_u, u_p, u_cp;
        Button u_c;
        u_u = SignUpFragment.findViewById(R.id.signup_uaername);
        u_p = SignUpFragment.findViewById(R.id.signup_password);
        u_cp = SignUpFragment.findViewById(R.id.confirm_password);
        u_c = SignUpFragment.findViewById(R.id.signup_confirm);
        u_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = u_u.getText().toString();
                String p = u_p.getText().toString();
                String cp = u_cp.getText().toString();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                int hasWritePermission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    if (!findUsr(u)) {
                        if (p.equals(cp)) {//往数据库里添加账号密码信息
                            UP newUser = new UP();
                            newUser.setUsername(u);
                            newUser.setPassword(p);
                            newUser.save();
                            U_info newInfo=new U_info();
                            newInfo.setUsername(u);
                            newInfo.setNickname(u);
                            newInfo.setSex(-1);
                            newInfo.setYear("1900");
                            newInfo.setMonth("1");
                            newInfo.setDay("1");
                            newInfo.save();
                            U_qs newQ=new U_qs();
                            newQ.setUsername(u);
                            newQ.save();
                            bundle.putBoolean("IS_LOGIN", true);
                            bundle.putString("USERNAME", u);
                            intent.putExtras(bundle);
                            getActivity().setResult(RESULT_OK, intent);
                            getActivity().finish();
                        } else {
                            Toast.makeText(getContext(), "两次密码不一致", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "用户名已存在", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return SignUpFragment;
    }
    public boolean findUsr(String usr) {
        boolean flag = false;
        List<UP> up = LitePal.where("username=?", usr).find(UP.class);
        if (up.size() > 0)
            if (up.get(0).getUsername().equals(usr))
                flag = true;
        return flag;
    }
}
