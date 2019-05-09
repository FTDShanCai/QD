package com.app.wanandroid.ui.articleList;


import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.app.wanandroid.R;
import com.app.wanandroid.R2;
import com.app.wanandroid.adapter.WanListAdapter;
import com.app.wanandroid.bean.ArticleResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BaseMvpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class WanArticleListActivity extends BaseMvpActivity<WanArticleListPresenter> implements WanArticleListView {

    @BindView(R2.id.tool_bar)
    Toolbar toolBar;
    @BindView(R2.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R2.id.refresh_layout)
    SmartRefreshLayout refresh_layout;
    private WanListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.wan_activity_article_list;
    }

    @Override
    protected WanArticleListPresenter getPresenter() {
        return new WanArticleListPresenter(this, this);
    }

    @Override
    protected void init() {
        presenter.getIntentData(getIntent());
    }


    @Override
    public void toast(String msg) {
        toastMsg(msg);
    }

    @Override
    public void setTitleBarInfo(String title) {
        toolBar.setTitle(title);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        refresh_layout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.getList(false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.getList(true);
            }
        });
        refresh_layout.autoRefresh();
    }

    @Override
    public void initListData(ArrayList<ArticleResult.Data> list) {
        adapter = new WanListAdapter(list);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusableInTouchMode(false);
        recyclerView.requestFocus();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getData().get(position) instanceof ArticleResult.Data) {
                    ArticleResult.Data data = (ArticleResult.Data) adapter.getData().get(position);

                    if (TextUtils.isEmpty(data.getLink())) {
                        return;
                    }

                    ARouter.getInstance().build(ARouterConstants.BASE_WEB)
                            .withString(ARouterConstants.Bundle.TITLE, data.getTitle())
                            .withString(ARouterConstants.Bundle.URL, data.getLink())
                            .navigation();
                }
            }
        });
    }

    @Override
    public void setRefreshLayoutEnable(boolean isLoadMore, boolean enable) {
        if (isLoadMore) {
            refresh_layout.setEnableLoadMore(enable);
        } else {
            refresh_layout.setEnableRefresh(enable);
        }
    }

    @Override
    public void refreshOrLoadMoreComplete(boolean isRefresh) {
        if (isRefresh) {
            refresh_layout.finishRefresh();
        } else {
            refresh_layout.finishLoadMore();
        }
    }

    @Override
    public void notifyDataChange() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }
}
