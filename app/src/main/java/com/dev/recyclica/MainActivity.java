package com.dev.recyclica;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dev.greenday.fragment.AuthorizationFragment;

import moxy.MvpAppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            final FragmentManager manager = getSupportFragmentManager();
            final Fragment fragment = new AuthorizationFragment();
            manager.beginTransaction()
                    .add(R.id.container, fragment, AuthorizationFragment.TAG)
                    .commit();
        }
    }
}
