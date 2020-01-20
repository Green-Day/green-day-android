package com.dev.recyclica.views;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SignUpView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showMessage (String msg);
}
