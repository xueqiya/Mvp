package com.yiya.mvp.model;

import android.os.Handler;

import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.HttpCallBack;
import com.yiya.mvp.contract.LoginContract;


public class LoginModelImpl implements LoginContract.Model {
    private LoginBean bean;

    public LoginModelImpl() {
    }

    //模拟网络请求
    @Override
    public void login(final String uid, String pwd, final HttpCallBack<LoginBean> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bean = new LoginBean();
                bean.setCode(200);
                bean.setMsg("登录成功");
                bean.setName(uid);
                callBack.onSuccess(bean);
            }
        }, 2000);
    }
}
