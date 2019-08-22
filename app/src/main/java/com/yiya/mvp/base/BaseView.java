package com.yiya.mvp.base;

public interface BaseView<T> {
    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 数据获取成功
     */
    void onSuccess(T bean);

    /**
     * 数据获取失败
     *
     * @param throwable
     */
    void onError(Throwable throwable);


}
