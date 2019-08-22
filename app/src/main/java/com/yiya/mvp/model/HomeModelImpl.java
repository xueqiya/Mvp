package com.yiya.mvp.model;

import android.os.Handler;

import com.yiya.mvp.bean.HomeBean;
import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.HomeContract;
import com.yiya.mvp.contract.HttpCallBack;

import java.util.ArrayList;
import java.util.List;

public class HomeModelImpl implements HomeContract.Model {

    @Override
    public void getData(final HttpCallBack<HomeBean> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeBean bean = new HomeBean();
                List<String> list = new ArrayList();
                for (int i = 0; i < 100; i++) {
                    list.add(i + "");
                }
                bean.setData(list);
                callBack.onSuccess(bean);
            }
        }, 2000);  //10这个数字是毫秒单位
    }
}
