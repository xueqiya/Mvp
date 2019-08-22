package com.yiya.mvp.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.HttpCallBack;
import com.yiya.mvp.contract.MainContract;


public class MainModel implements MainContract.Model {
    private LoginBean bean;

    public MainModel() {
    }

    //模拟网络请求
    @Override
    public void login(final String uid, String pwd, final HttpCallBack<LoginBean> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);//休眠3秒
                    bean = new LoginBean();
                    bean.setCode(200);
                    bean.setMsg("登录成功");
                    bean.setName(uid);
                    callBack.onSuccess(bean);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);  //10这个数字是毫秒单位
    }
}
