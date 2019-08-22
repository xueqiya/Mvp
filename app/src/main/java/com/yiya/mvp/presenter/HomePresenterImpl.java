package com.yiya.mvp.presenter;

import android.content.Context;

import com.yiya.mvp.bean.HomeBean;
import com.yiya.mvp.contract.HomeContract;
import com.yiya.mvp.contract.HttpCallBack;
import com.yiya.mvp.model.HomeModelImpl;

public class HomePresenterImpl implements HomeContract.Presenter, HttpCallBack<HomeBean> {

    private final HomeContract.Model model;
    private HomeContract.View view;

    public HomePresenterImpl(HomeContract.View context) {
        model = new HomeModelImpl();
        this.view = context;
    }

    @Override
    public void getData() {
        view.showLoading();
        model.getData(this);
    }

    @Override
    public void onSuccess(HomeBean bean) {
        view.hideLoading();
        view.onSuccess(bean);
    }

    @Override
    public void error() {
        view.hideLoading();
    }
}
