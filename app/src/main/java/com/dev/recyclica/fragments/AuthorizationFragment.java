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

import moxy.MvpAppCompatFragment;

public class AuthorizationFragment extends MvpAppCompatFragment {

    public final static String TAG = "Authorization";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_input, container, false);

        final FragmentManager manager = getFragmentManager();
        final Fragment fragment = new SingUpFragment();
        if (manager != null) {
            manager.beginTransaction()
                    .replace(R.id.menu_container, fragment, SingUpFragment.TAG)
                    .commit();
        }

        return v;
    }
}
