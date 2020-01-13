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
import com.dev.recyclica.views.SignInView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class SignInFragment extends MvpAppCompatFragment implements SignInView {

    final static String TAG = "SignIn";
    private Unbinder unbinder;

    @OnClick(R.id.bt_sign_in)
    void singIn() {
        final FragmentManager manager = getFragmentManager();
        final Fragment fragment = new MainMenuFragment();
        if (manager != null) {
            manager.beginTransaction()
                    .replace(R.id.container, fragment, MainMenuFragment.TAG)
                    .commit();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_sign_in, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
