package com.dev.recyclica.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dev.recyclica.R;

import moxy.MvpAppCompatFragment;

public class SingUpFragment extends MvpAppCompatFragment {

    public final static String TAG = "Authorization";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_sing_up, container, false);
        
        return v;
    }
}
