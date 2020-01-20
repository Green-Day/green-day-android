package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dev.recyclica.R;
import com.dev.recyclica.presenters.SignUpPresenter;
import com.dev.recyclica.views.SignUpView;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class SignUpFragment extends MvpAppCompatFragment implements SignUpView {

    final static String TAG = "SingUp";
    private Unbinder unbinder;

    @BindView(R.id.et_login)
    EditText mEditTextLogin;

    @BindView(R.id.et_first_password)
    EditText mEditTextFirstPassword;

    @BindView(R.id.et_second_password)
    EditText mEditTextSecondPassword;

    @BindView(R.id.firstPasswordLayout)
    TextInputLayout mFirstTextLayout;

    @BindView(R.id.pb_sign_up)
    ProgressBar mProgressBarSignUp;

    @InjectPresenter
    SignUpPresenter presenter;

    @OnClick(R.id.bt_sign_in)
    void singUp() {
        presenter.registrationWithEmail(mEditTextLogin.getText().toString(),
                mEditTextLogin.getText().toString(),
                mEditTextFirstPassword.getText().toString(),
                "kavoo@mail.ru");

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_registration, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showMessage(String msg) {
        if (msg != null) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "String is null", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showProgressBar() {
        mProgressBarSignUp.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBarSignUp.setVisibility(View.GONE);
    }

    @Override
    public void moveToSignIn() {
        final FragmentManager manager = getFragmentManager();
        if (manager != null) {
            final Fragment fragment = new SignInFragment();
            manager.beginTransaction()
                    .replace(R.id.activity_container, fragment, SignInFragment.TAG)
                    .commit();
        }

    }
}
