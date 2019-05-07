package com.app.wanandroid.ui.main;

import com.app.wanandroid.R;
import com.example.qd_base.mvp.BaseMvpActivity;

public class WanMainActivity extends BaseMvpActivity<WanMainPresenter> implements WanMainView {

    @Override
    protected int getLayoutId() {
        return R.layout.wan_activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected WanMainPresenter getPresenter() {
        return new WanMainPresenter(this, this);
    }


    @Override
    public void toast(String msg) {
        toastMsg(msg);
    }
}
