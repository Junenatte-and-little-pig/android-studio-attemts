package com.example.thinkpad.dialogdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class myDialogFragment extends DialogFragment {
    EditText et_username,et_password;
    Button confirmBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_my_dialog, container, false);
        et_username=v.findViewById(R.id.username);
        et_password=v.findViewById(R.id.password);
        confirmBtn=v.findViewById(R.id.confirm);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),et_username.getText()+" "+et_password.getText(),Toast.LENGTH_LONG).show();
                dismiss();
            }
        });
        return v;
    }
}
