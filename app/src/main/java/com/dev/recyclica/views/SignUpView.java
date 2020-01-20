package com.dev.recyclica.views;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SignUpView extends MvpView {

    void showMessage(String msg);
    void showProgressBar();
    void hideProgressBar();
    void moveToSignIn();
}
