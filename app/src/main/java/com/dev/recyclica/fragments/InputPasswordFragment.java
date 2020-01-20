package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dev.recyclica.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class InputPasswordFragment extends MvpAppCompatFragment {

    @BindView(R.id.tv_login)
    TextView mTextViewLogin;

    @BindView(R.id.et_first_password_layout)
    TextInputLayout mFirstPasswordLayout;

    @BindView(R.id.et_second_password_layout)
    TextInputLayout mSecondPasswordLayout;

    @BindView(R.id.et_second_password)
    EditText mEditTextSecondPassword;

    @BindView(R.id.et_first_password)
    EditText mEditTextFirstPassword;

    @OnClick(R.id.bt_sign_up)
    void signUp() {
        final String firstPassword = mEditTextFirstPassword.getText().toString();
        final String secondPassword = mEditTextSecondPassword.getText().toString();

        if (!firstPassword.equals(secondPassword)) {
            mSecondPasswordLayout.setError(getString(R.string.error_passwords_is_not_equals));
            mFirstPasswordLayout.setError(getString(R.string.error_passwords_is_not_equals));
            return;
        }
    }

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input_password, container, false);
        unbinder = ButterKnife.bind(this, v);
        if (getArguments() != null)
            mTextViewLogin.setText(getArguments().getString(LOGIN_KEY));

        return v;
    }

    public static InputPasswordFragment newInstance(String login) {
        Bundle args = new Bundle();
        args.putString(LOGIN_KEY, login);
        InputPasswordFragment fragment = new InputPasswordFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private static String LOGIN_KEY = "login";

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
