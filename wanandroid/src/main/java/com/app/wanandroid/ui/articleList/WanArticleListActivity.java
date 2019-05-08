package com.app.wanandroid.ui.articleList;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.app.wanandroid.R;
import com.app.wanandroid.R2;
import com.example.qd_base.mvp.BaseMvpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.BindView;

public class WanArticleListActivity extends BaseMvpActivity<WanArticleListPresenter> implements WanArticleListView {

    @BindView(R2.id.tool_bar)
    Toolbar toolBar;
    @BindView(R2.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R2.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

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

        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }
}
