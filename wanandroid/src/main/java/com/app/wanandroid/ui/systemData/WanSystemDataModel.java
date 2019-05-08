package com.app.wanandroid.ui.systemData;

import android.content.Context;

import com.app.wanandroid.api.WanApi;
import com.app.wanandroid.bean.SystemData;
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
public class WanSystemDataModel extends BaseModel<ActivityEvent> {

    public void getSystemDatas(Context context, BaseResponse<WanBaseResult<ArrayList<SystemData>>> response) {
        BaseNet.get().api(WanApi.url).getApi(WanApi.class)
                .getSystemDatas()
                .compose(RxSchedulers.compose())
                .compose(RxSchedulers.dialog(context))
                .compose(provider.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(response);
    }
}
