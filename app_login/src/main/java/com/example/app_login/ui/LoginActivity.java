package com.example.app_login.ui;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.app_login.LoginApi;
import com.example.app_login.R;
import com.example.app_login.entity.LoginEntity;
import com.example.qd_base.AppStatus;
import com.example.qd_base.BaseActivity;
import com.example.qd_base.BaseNet;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.BaseResult;
import com.example.qd_base.net.CacheMode;
import com.example.qd_base.RxSchedulers;
import com.google.gson.Gson;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;

@Route(path = "/login/login")
public class LoginActivity extends BaseActivity {

    Button btn, btn_isNet;
    TextView tv_response;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        btn = findViewById(R.id.btn);
        tv_response = findViewById(R.id.tv_response);
        btn_isNet = findViewById(R.id.btn_isNet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btn_isNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppStatus.isOnline = !AppStatus.isOnline;
                btn_isNet.setText(AppStatus.isOnline + "");
            }
        });
        btn_isNet.setText(AppStatus.isOnline + "");
    }

    private void login() {
        BaseNet.get().api("https://wanandroid.com/").setCacheMode(CacheMode.NoCache)
                .getApi(LoginApi.class)
                .login()
                .compose(RxSchedulers.compose())
                .compose(RxSchedulers.dialog(this))
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new BaseResponse<BaseResult<ArrayList<LoginEntity>>>() {
                    @Override
                    protected void onSuccess(BaseResult<ArrayList<LoginEntity>> result, String msg) {
                        tv_response.setText(new Gson().toJson(result));
                        Toast.makeText(LoginActivity.this, msg + "   " + result.getData().get(0).getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void onError(String error) {
                        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void as() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            manager.requestNetwork(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                }

                @Override
                public void onLost(Network network) {
                    super.onLost(network);
                }
            });
        }
    }

}
