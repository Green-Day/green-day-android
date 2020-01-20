package com.dev.recyclica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dev.recyclica.fragments.AuthorizationFragment;

import moxy.MvpAppCompatActivity;

public class MainActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            final FragmentManager manager = getSupportFragmentManager();
            final Fragment fragment = new AuthorizationFragment();
            manager.beginTransaction()
                    .add(R.id.activity_container, fragment, AuthorizationFragment.TAG)
                    .commit();
        }
    }
}
