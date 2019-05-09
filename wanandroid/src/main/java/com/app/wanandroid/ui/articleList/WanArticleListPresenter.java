package com.app.wanandroid.ui.articleList;

import android.content.Context;
import android.content.Intent;

import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.net.WanBaseResult;
import com.app.wanandroid.util.Contacts;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanArticleListPresenter extends BasePresenter<WanArticleListModel, WanArticleListView, ActivityEvent> {

    private String cid;
    private int page = 0;
    private ArrayList<ArticleResult.Data> list = new ArrayList<>();

    public WanArticleListPresenter(Context context, WanArticleListView view) {
        super(context, view);
    }

    @Override
    protected WanArticleListModel getModel() {
        return new WanArticleListModel();
    }

    public void getIntentData(Intent intent) {
        view.initListData(list);
        if (intent != null) {
            cid = intent.getStringExtra(Contacts.CID);
            view.setTitleBarInfo(intent.getStringExtra(Contacts.TITLE));
        } else {
            view.setTitleBarInfo("列表");
        }
    }

    public void getList(boolean isRefresh) {
        if (isRefresh) {
            page = 0;
        }

        model.getArticleListFromCid(page, cid, new BaseResponse<WanBaseResult<ArticleResult>>() {
            @Override
            protected void onSuccess(WanBaseResult<ArticleResult> articleResultWanBaseResult, String msg) {
                view.refreshOrLoadMoreComplete(isRefresh);
                if (isRefresh) {
                    list.clear();
                    view.notifyDataChange();
                }

                if (articleResultWanBaseResult.getData().getDatas() != null && articleResultWanBaseResult.getData().getDatas().size() != 0) {
                    list.addAll(articleResultWanBaseResult.getData().getDatas());
                    view.notifyDataChange();
                    page++;
                    view.setRefreshLayoutEnable(true, true);
                } else {
                    view.setRefreshLayoutEnable(true, false);
                    view.toast("没有更多数据了~");
                }

            }

            @Override
            protected void onError(String error) {
                view.refreshOrLoadMoreComplete(isRefresh);
                view.toast(error);
            }
        });
    }
}
