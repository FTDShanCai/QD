package com.app.wanandroid.ui.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.app.wanandroid.R;
import com.app.wanandroid.R2;
import com.app.wanandroid.adapter.WanListAdapter;
import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.bean.BannerData;
import com.app.wanandroid.ui.systemData.WanSystemDataActivity;
import com.app.wanandroid.ui.usuallyNet.WanUsuallyNetActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BaseMvpActivity;
import com.example.qd_base.util.GlideUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.lang.reflect.Method;
import java.util.ArrayList;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;


@Route(path = ARouterConstants.Module.WanAndroid.WAN_ANDROID_MAIN)
public class WanMainActivity extends BaseMvpActivity<WanMainPresenter> implements WanMainView ,NavigationCallback{

    @BindView(R2.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R2.id.bga_banner)
    BGABanner bgaBanner;
    @BindView(R2.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R2.id.scroll_view)
    NestedScrollView scrollView;
    @BindView(R2.id.refresh_layout)
    SmartRefreshLayout refresh_layout;

    private WanListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.wan_activity_main;
    }

    @Override
    protected void init() {
        tool_bar.setTitle("WanAndroid");
        setSupportActionBar(tool_bar);
        presenter.getMainBanner();
    }

    @Override
    protected WanMainPresenter getPresenter() {
        return new WanMainPresenter(this, this);
    }


    @Override
    public void toast(String msg) {
        toastMsg(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wan_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.menu_system) {
            ARouter.getInstance().build(ARouterConstants.Module.WanAndroid.WAN_ANDROID_SYSTEMDATA)
                    .navigation(this, this);
        } else if (i == R.id.menu_net) {
            ARouter.getInstance().build(ARouterConstants.Module.WanAndroid.WAN_ANDROID_USUALLYNET)
                    .navigation(this, this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void setBanner(ArrayList<BannerData> banner, ArrayList<String> desc) {
        bgaBanner.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, @Nullable Object model, int position) {
                if (model instanceof BannerData) {
                    BannerData data = (BannerData) model;
                    GlideUtil.load(WanMainActivity.this, data.getImagePath(), (ImageView) itemView);
                }
            }
        });
        bgaBanner.setData(banner, desc);
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

                    ARouter.getInstance().build(ARouterConstants.Module.BASE_WEB)
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

    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {
        toastMsg(postcard.getPath() + " | onLost");
    }

    @Override
    public void onArrival(Postcard postcard) {

    }

    @Override
    public void onInterrupt(Postcard postcard) {
        toastMsg(postcard.getPath() + " | onInterrupt");
    }

}
