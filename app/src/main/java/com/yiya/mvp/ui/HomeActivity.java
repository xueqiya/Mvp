package com.yiya.mvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import com.yiya.mvp.R;
import com.yiya.mvp.adapter.HomeAdapter;
import com.yiya.mvp.bean.HomeBean;
import com.yiya.mvp.contract.HomeContract;
import com.yiya.mvp.presenter.HomePresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    private ListView listView;
    private HomeContract.Presenter presenter;
    private List<String> list;
    private HomeAdapter homeAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载");
        list = new ArrayList<>();
        listView = findViewById(R.id.list);
        homeAdapter = new HomeAdapter(list);
        listView.setAdapter(homeAdapter);

        presenter = new HomePresenterImpl(this);
        presenter.getData();
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
    public void onSuccess(HomeBean bean) {
        list.addAll(bean.getData());
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
