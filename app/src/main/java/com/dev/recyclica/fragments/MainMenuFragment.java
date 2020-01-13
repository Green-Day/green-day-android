package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dev.recyclica.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class MainMenuFragment extends MvpAppCompatFragment {

    public final static String TAG = "MainMenu";
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_menu, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
