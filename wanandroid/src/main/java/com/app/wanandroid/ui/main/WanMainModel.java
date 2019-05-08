package com.app.wanandroid.ui.main;

import android.content.Context;

import com.app.wanandroid.api.WanApi;
import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.bean.BannerData;
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
public class WanMainModel extends BaseModel<ActivityEvent> {

    public void getBanner(Context context, BaseResponse<WanBaseResult<ArrayList<BannerData>>> response) {
        BaseNet.get().api(WanApi.url).getApi(WanApi.class)
                .getBanner().compose(RxSchedulers.compose())
                .compose(RxSchedulers.dialog(context))
                .compose(provider.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(response);
    }

    public void getArticleList(int page, BaseResponse<WanBaseResult<ArticleResult>> response) {
        BaseNet.get().api(WanApi.url).getApi(WanApi.class)
                .getArticleProjectList(page)
                .compose(RxSchedulers.compose())
                .compose(provider.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(response);
    }
}
