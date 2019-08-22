package com.yiya.mvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yiya.mvp.App;
import com.yiya.mvp.R;
import com.yiya.mvp.bean.LoginBean;
import com.yiya.mvp.contract.LoginContract;
import com.yiya.mvp.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;
    private EditText uid;
    private EditText pwd;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter = new LoginPresenterImpl(this);
    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载");
        uid = findViewById(R.id.uid);
        pwd = findViewById(R.id.pwd);
    }

    public void login(View v) {
        presenter.login(uid.getText().toString(), pwd.getText().toString());
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onSuccess(LoginBean bean) {
        Toast.makeText(App.getContext(), bean.getMsg() + "\n用户名：" + bean.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(App.getContext(), "登录失败", Toast.LENGTH_SHORT).show();
    }

}
