package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dev.recyclica.R;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class InputLoginFragment extends MvpAppCompatFragment {

    private Unbinder unbinder;

    @BindView(R.id.et_login)
    EditText mEditTextLogin;

    @BindView(R.id.et_login_layout)
    TextInputLayout mEditTextLayoutLogin;

    @OnClick(R.id.bt_next_step)
    void nextStep() {
        if (mEditTextLogin.getText().toString().trim().equals("")) {
            mEditTextLayoutLogin.setError(getString(R.string.error_login_or_email_is_empty));
            return;
        }
        final Fragment fragment = InputPasswordFragment.newInstance(mEditTextLogin.getText().toString());
        final FragmentManager manager = getFragmentManager();
        if (manager != null) {
            manager.beginTransaction()
                    .addToBackStack(TAG)
                    .replace(R.id.menu_container, fragment, SignUpFragment.TAG)
                    .commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input_login, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
