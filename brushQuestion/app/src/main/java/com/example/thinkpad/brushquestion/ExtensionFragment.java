package com.example.thinkpad.brushquestion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExtensionFragment extends Fragment {
    View extensionView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(extensionView==null)
            extensionView=inflater.inflate(R.layout.extension,null);
        return extensionView;
    }
}
