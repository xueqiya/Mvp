package com.yiya.mvp.contract;

import com.yiya.mvp.base.BaseView;
import com.yiya.mvp.bean.HomeBean;

public interface HomeContract {
    interface Model {
        void getData(HttpCallBack<HomeBean> callBack);
    }

    interface View extends BaseView<HomeBean> {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onSuccess(HomeBean bean);

        @Override
        void onError(Throwable throwable);
    }

    interface Presenter {
        void getData();
    }
}
