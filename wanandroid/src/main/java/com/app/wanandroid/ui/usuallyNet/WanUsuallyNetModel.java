package com.app.wanandroid.ui.usuallyNet;

import android.content.Context;

import com.app.wanandroid.api.WanApi;
import com.app.wanandroid.bean.UsuallyNetData;
import com.app.wanandroid.net.WanBaseResult;
import com.example.qd_base.BaseNet;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.RxSchedulers;
import com.example.qd_base.mvp.BaseModel;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanUsuallyNetModel extends BaseModel<ActivityEvent> {

    public void getUsuallyNet(Context context, BaseResponse<WanBaseResult<ArrayList<UsuallyNetData>>> response) {
        BaseNet.get().api(WanApi.url).getApi(WanApi.class)
                .getUsuallyNet().compose(RxSchedulers.compose())
                .compose(RxSchedulers.dialog(context))
                .compose(provider.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(response);
    }
}
