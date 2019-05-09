package com.app.wanandroid.ui.usuallyNet;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.app.wanandroid.R;
import com.app.wanandroid.R2;
import com.app.wanandroid.adapter.WanUsuallyNetAdapter;
import com.app.wanandroid.bean.UsuallyNetData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BaseMvpActivity;

import java.util.ArrayList;

import butterknife.BindView;

@Route(path = ARouterConstants.Module.WanAndroid.WAN_ANDROID_USUALLYNET)
public class WanUsuallyNetActivity extends BaseMvpActivity<WanUsuallyNetPresenter> implements WanUsuallyNetView {

    @BindView(R2.id.tool_bar)
    Toolbar toolBar;
    @BindView(R2.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected int getLayoutId() {
        return R.layout.wan_activity_usually_net;
    }

    @Override
    protected WanUsuallyNetPresenter getPresenter() {
        return new WanUsuallyNetPresenter(this, this);
    }

    @Override
    protected void init() {
        toolBar.setTitle("常用网站");
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        presenter.getData();
    }

    @Override
    public void toast(String msg) {
        toastMsg(msg);
    }

    @Override
    public void setUsuallyNetData(ArrayList<UsuallyNetData> list) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        WanUsuallyNetAdapter adapter = new WanUsuallyNetAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getData().get(position) instanceof UsuallyNetData) {
                    UsuallyNetData data = (UsuallyNetData) adapter.getData().get(position);

                    if (TextUtils.isEmpty(data.getLink())) {
                        return;
                    }

                    ARouter.getInstance().build(ARouterConstants.Module.BASE_WEB)
                            .withString(ARouterConstants.Bundle.TITLE, data.getName())
                            .withString(ARouterConstants.Bundle.URL, data.getLink())
                            .navigation();
                }
            }
        });
    }
}
