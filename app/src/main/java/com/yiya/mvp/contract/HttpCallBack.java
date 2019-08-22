package com.yiya.mvp.contract;

public interface HttpCallBack<T> {
        void onSuccess(T bean);

        void error();
    }