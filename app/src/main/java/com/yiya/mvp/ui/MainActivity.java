package com.yiya.mvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yiya.mvp.R;
import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.MainContract;
import com.yiya.mvp.presenter.MainPresenter;
import com.yiya.mvp.utils.ProgressDialogUtils;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;
    private EditText uid;
    private EditText pwd;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new MainPresenter(this);
    }

    private void initView() {
        uid = findViewById(R.id.uid);
        pwd = findViewById(R.id.pwd);
    }

    public void login(View v) {
        presenter.login(uid.getText().toString(), pwd.getText().toString());
    }

    @Override
    public void showLoading() {
        ProgressDialogUtils.getInstance(this).show();
    }

    @Override
    public void hideLoading() {
        ProgressDialogUtils.getInstance(this).dismiss();
    }

    @Override
    public void onSuccess(LoginBean bean) {
        Toast.makeText(this, bean.getMsg() + "\n用户名：" + bean.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
