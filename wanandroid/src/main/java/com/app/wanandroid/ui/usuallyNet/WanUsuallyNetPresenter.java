package com.app.wanandroid.ui.usuallyNet;

import android.content.Context;

import com.app.wanandroid.bean.UsuallyNetData;
import com.app.wanandroid.net.WanBaseResult;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanUsuallyNetPresenter extends BasePresenter<WanUsuallyNetModel, WanUsuallyNetView, ActivityEvent> {

    public WanUsuallyNetPresenter(Context context, WanUsuallyNetView view) {
        super(context, view);
    }

    @Override
    protected WanUsuallyNetModel getModel() {
        return new WanUsuallyNetModel();
    }

    public void getData() {
        model.getUsuallyNet(context.get(), new BaseResponse<WanBaseResult<ArrayList<UsuallyNetData>>>() {
            @Override
            protected void onSuccess(WanBaseResult<ArrayList<UsuallyNetData>> result, String msg) {
                view.setUsuallyNetData(result.getData());
            }

            @Override
            protected void onError(String error) {
                view.toast(error);
            }
        });
    }
}
