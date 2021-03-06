package com.app.wanandroid.ui.articleList;

import com.app.wanandroid.api.WanApi;
import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.net.WanBaseResult;
import com.example.qd_base.BaseNet;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.RxSchedulers;
import com.example.qd_base.mvp.BaseModel;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanArticleListModel extends BaseModel<ActivityEvent> {

    public void getArticleListFromCid(int page, String cid, BaseResponse<WanBaseResult<ArticleResult>> response) {
        BaseNet.get().api(WanApi.url).getApi(WanApi.class)
                .getArticleListFromCid(page, cid)
                .compose(RxSchedulers.compose())
                .compose(provider.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(response);
    }

}
