package com.yiya.mvp.contract;

import com.yiya.mvp.bean.LoginBean;

public interface MainContract {
    interface Model {
        void login(String uid, String pwd, HttpCallBack<LoginBean> callBack);
    }

    interface View {
        void showLoading();

        void hideLoading();

        void onSuccess(LoginBean bean);

        void onError();
    }

    interface Presenter {
        void login(String uid, String pwd);
    }
}
