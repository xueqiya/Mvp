package com.yiya.mvp.utils;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;

import com.yiya.mvp.App;

/**
 * @author azheng
 * @date 2018/5/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：圆形进度条Dialog
 */
public class ProgressDialogUtils {

    private static ProgressDialogUtils instance;
    private static ProgressDialog progressDialog;

    public static ProgressDialogUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (ProgressDialogUtils.class) {
                if (instance == null) {
                    instance = new ProgressDialogUtils();
                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("正在加载");
                }
            }
        }
        return instance;
    }

    public void show() {
        progressDialog.show();
    }

    public void dismiss() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
