package com.yiya.mvp.presenter;

import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.HttpCallBack;
import com.yiya.mvp.contract.LoginContract;
import com.yiya.mvp.model.LoginModelImpl;

public class LoginPresenterImpl implements LoginContract.Presenter, HttpCallBack<LoginBean> {

    private LoginContract.Model model;
    private LoginContract.View view;

    public LoginPresenterImpl(LoginContract.View context) {
        model = new LoginModelImpl();
        view = context;
    }

    @Override
    public void login(String uid, String pwd) {
        view.showLoading();
        model.login(uid, pwd, this);
    }

    @Override
    public void onSuccess(LoginBean bean) {
        view.hideLoading();
        view.onSuccess(bean);
    }

    @Override
    public void error() {
        view.hideLoading();
    }
}
