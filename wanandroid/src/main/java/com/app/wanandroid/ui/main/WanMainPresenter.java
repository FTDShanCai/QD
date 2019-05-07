package com.app.wanandroid.ui.main;

import android.content.Context;

import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanMainPresenter extends BasePresenter<WanMainModel, WanMainView, ActivityEvent> {

    public WanMainPresenter(Context context, WanMainView view) {
        super(context, view);
    }

    @Override
    protected WanMainModel getModel() {
        return new WanMainModel();
    }
}
