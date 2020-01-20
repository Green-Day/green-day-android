package com.dev.recyclica.presenters;

import android.util.Log;

import com.dev.recyclica.api.Api;
import com.dev.recyclica.api.ApiFactory;
import com.dev.recyclica.dto.Answer;
import com.dev.recyclica.dto.User;
import com.dev.recyclica.views.SignUpView;

import org.jetbrains.annotations.NotNull;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

@InjectViewState
public class SignUpPresenter extends MvpPresenter<SignUpView> {

    private final Api api = ApiFactory.getInstance();
    private final SignUpView viewState = getViewState();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void registrationWithPhone(String username,
                                      String fullname,
                                      String password,
                                      String email) {
        Call<Answer> call = api.getRegistratedUser(new User(username, fullname, password, email),
                "application/json");
        call.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(@NotNull Call<Answer> call, @NotNull Response<Answer> response) {
                if (response.isSuccessful()) {
                    Answer answer = response.body();
                    if (answer != null && answer.getUser() != null) {
                        viewState.showMessage("SUCCESS");
                    } else if (answer != null && answer.getError() != null) {
                        viewState.showMessage(answer.getError());
                    } else {
                        viewState.showMessage("ERROR");
                    }
                } else {
                    viewState.showMessage(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(@NotNull Call<Answer> call, @NotNull Throwable t) {
                viewState.showMessage(t.getMessage());
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
