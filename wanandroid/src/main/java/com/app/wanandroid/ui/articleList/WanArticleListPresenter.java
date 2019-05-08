package com.app.wanandroid.ui.articleList;

import android.content.Context;
import android.content.Intent;

import com.app.wanandroid.util.Contacts;
import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanArticleListPresenter extends BasePresenter<WanArticleListModel, WanArticleListView, ActivityEvent> {

    private String cid;

    public WanArticleListPresenter(Context context, WanArticleListView view) {
        super(context, view);
    }

    @Override
    protected WanArticleListModel getModel() {
        return new WanArticleListModel();
    }

    public void getIntentData(Intent intent) {
        if (intent != null) {
            cid = intent.getStringExtra(Contacts.CID);
            view.setTitleBarInfo(intent.getStringExtra(Contacts.TITLE));
        } else {
            view.setTitleBarInfo("列表");
        }


    }

}
