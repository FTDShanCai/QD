package com.app.wanandroid.ui.main;

import android.content.Context;

import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.bean.BannerData;
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
public class WanMainPresenter extends BasePresenter<WanMainModel, WanMainView, ActivityEvent> {

    private ArrayList<ArticleResult.Data> list = new ArrayList<>();
    private int page = 1;


    public WanMainPresenter(Context context, WanMainView view) {
        super(context, view);
    }

    @Override
    protected WanMainModel getModel() {
        return new WanMainModel();
    }


    public void getMainBanner() {
        model.getBanner(context.get(), new BaseResponse<WanBaseResult<ArrayList<BannerData>>>() {
            @Override
            protected void onSuccess(WanBaseResult<ArrayList<BannerData>> result, String msg) {

                ArrayList<String> desc = new ArrayList<>();
                for (BannerData data :
                        result.getData()) {
                    desc.add(data.getTitle());
                }

                view.setBanner(result.getData(), desc);
            }

            @Override
            protected void onError(String error) {
                view.toast(error);
            }
        });

        view.initListData(list);
    }

    public void getList(boolean isRefresh) {
        if (isRefresh) {
            page = 1;
        }

        model.getArticleList(page, new BaseResponse<WanBaseResult<ArticleResult>>() {
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
