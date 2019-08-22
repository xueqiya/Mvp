package com.yiya.mvp.contract;

import com.yiya.mvp.base.BaseView;
import com.yiya.mvp.bean.LoginBean;

public interface LoginContract {
    interface Model {
        void login(String uid, String pwd, HttpCallBack<LoginBean> callBack);
    }

    interface View extends BaseView<LoginBean> {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onSuccess(LoginBean bean);

        @Override
        void onError(Throwable throwable);
    }

    interface Presenter {
        void login(String uid, String pwd);
    }
}
