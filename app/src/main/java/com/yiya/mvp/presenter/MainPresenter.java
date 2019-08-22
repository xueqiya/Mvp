package com.yiya.mvp.presenter;

import android.content.Context;

import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.HttpCallBack;
import com.yiya.mvp.contract.MainContract;
import com.yiya.mvp.model.MainModel;

public class MainPresenter implements MainContract.Presenter, HttpCallBack<LoginBean> {

    private MainContract.Model model;
    private MainContract.View view;

    public MainPresenter(MainContract.View context) {
        model = new MainModel();
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
        view.onError();
    }
}
