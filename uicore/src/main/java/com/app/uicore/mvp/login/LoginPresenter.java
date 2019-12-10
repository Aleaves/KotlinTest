package com.app.uicore.mvp.login;

import com.app.uicore.mvp.base.BaseEntity;
import com.app.uicore.mvp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView loginView) {
        super(loginView);
    }

    public void login(){

    }

    @Override
    protected void onLoadDataSuccess(BaseEntity entity) {
        getView().loginComplete();
    }

    @Override
    protected void onLoadDataFailure(String msg) {

    }

}
