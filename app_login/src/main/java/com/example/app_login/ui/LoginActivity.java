package com.example.app_login.ui;


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
import com.example.qd_base.BaseActivity;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.BaseResult;
import com.example.qd_base.RetrofitUtil;
import com.example.qd_base.RxSchedulers;
import com.google.gson.Gson;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;


@Route(path = "/login/login")
public class LoginActivity extends BaseActivity {

    Button btn;
    TextView tv_response;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        btn = findViewById(R.id.btn);
        tv_response = findViewById(R.id.tv_response);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        LoginApi api = RetrofitUtil.getInstance().getApi("https://wanandroid.com/", LoginApi.class);
        api.login()
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

}
