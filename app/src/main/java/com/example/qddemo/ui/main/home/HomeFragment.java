package com.example.qddemo.ui.main.home;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BaseMvpFragment;
import com.example.qddemo.R;
import com.example.qddemo.adapter.HomeAdapter;
import com.example.qddemo.bean.HomeBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeView, NavigationCallback, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private HomeAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        presenter.getHomeData();
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(getActivity(), this);
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setHomeData(ArrayList<HomeBean> list) {
        recycler_view.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter = new HomeAdapter(list);
        recycler_view.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void toast(String msg) {
        toastMsg(msg);
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

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter.getData().get(position) instanceof HomeBean) {
            HomeBean bean = (HomeBean) adapter.getData().get(position);
            switch (bean.getHomeEnum()) {
                case 天气:
                    ARouter.getInstance().build(ARouterConstants.Module.Weahter.WEATHER_MAIN)
                            .navigation(getActivity(), this);
                    break;
            }
        }
    }
}
