package com.dev.recyclica.presenters;

import android.util.Log;

import com.dev.recyclica.api.Api;
import com.dev.recyclica.api.ApiFactory;
import com.dev.recyclica.dto.Answer;
import com.dev.recyclica.views.SignUpView;

import moxy.MvpPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SignUpPresenter extends MvpPresenter<SignUpView> {

    private final Api api = ApiFactory.getInstance();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void registrationWithPhone(String username,
                                      String fullname,
                                      String password,
                                      int phone) {
        Call<Answer> call = api.getRegistratedUser(username, fullname, password, phone);
        call.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                if (response.isSuccessful()) {
                    Answer answer = response.body();
                    if (answer != null && answer.getError() != null) {
                        Log.i(TAG, "User: " + answer.getUser().toString());
                    } else {
                        Log.e(TAG, "Error: " + answer.getError());

                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                Log.e(TAG, "Failed " + t.getMessage());
            }
        });
    }

    public void registrationWithEmail(String username,
                                      String fullname,
                                      String password,
                                      String email) {

    }

    public void registrationWithEmailAndPhone(String username,
                                              String fullname,
                                              String password,
                                              String email,
                                              int phone) {
    }
}
