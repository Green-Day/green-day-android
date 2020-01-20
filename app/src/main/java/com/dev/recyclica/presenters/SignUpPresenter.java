package com.dev.recyclica.presenters;

import android.util.Log;

import com.dev.recyclica.api.Api;
import com.dev.recyclica.api.ApiFactory;
import com.dev.recyclica.dto.Answer;
import com.dev.recyclica.dto.Error;
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
                                      int phone) {
        processRequest(new User(username, fullname, password, phone));

    }

    public void registrationWithEmail(String username,
                                      String fullname,
                                      String password,
                                      String email) {
        processRequest(new User(username, fullname, password, email));
    }

    private void processRequest(User newUser) {
        viewState.showProgressBar();
        Call<Error> call = api.getRegistratedUser(newUser,
                "application/json");
        call.enqueue(new Callback<Error>() {
            @Override
            public void onResponse(@NotNull Call<Error> call, @NotNull Response<Error> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    viewState.moveToSignIn();
                } else {
                    if (response.body() != null && response.body().getError() != null)
                        viewState.showMessage(response.body().getError());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Error> call, @NotNull Throwable t) {
                viewState.showMessage(t.getMessage());
            }
        });
        viewState.hideProgressBar();
    }
}
