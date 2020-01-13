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

public class AuthorizationFragment extends MvpAppCompatFragment {

    public final static String TAG = "Authorization";
    private Unbinder unbinder;

    @OnClick(R.id.bt_sign_up)
    void singUp() {
        final FragmentManager manager = getFragmentManager();
        if (manager != null) {
            manager.beginTransaction()
                    .addToBackStack(TAG)
                    .replace(R.id.container, new SignUpFragment(), SignUpFragment.TAG)
                    .commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_input, container, false);
        unbinder = ButterKnife.bind(this, v);

        final FragmentManager manager = getFragmentManager();
        final Fragment fragment = new SignInFragment();
        if (manager != null) {
            manager.beginTransaction()
                    .replace(R.id.menu_container, fragment, SignInFragment.TAG)
                    .commit();
        }

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
