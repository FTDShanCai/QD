package com.app.wanandroid.ui.systemData;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.app.wanandroid.R;
import com.app.wanandroid.R2;
import com.app.wanandroid.adapter.WanSystemDataAdapter;
import com.app.wanandroid.bean.SystemData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BaseMvpActivity;

import java.util.ArrayList;

import butterknife.BindView;

@Route(path = ARouterConstants.Module.WanAndroid.WAN_ANDROID_SYSTEMDATA)
public class WanSystemDataActivity extends BaseMvpActivity<WanSystemDataPresenter> implements WanSystemDataView {
    @BindView(R2.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R2.id.tool_bar)
    Toolbar tool_bar;

    private WanSystemDataAdapter adapter;

    @Override

    protected int getLayoutId() {
        return R.layout.wan_activity_system_data;
    }

    @Override
    protected WanSystemDataPresenter getPresenter() {
        return new WanSystemDataPresenter(this, this);
    }

    @Override
    protected void init() {
        tool_bar.setTitle("体系结构");
        tool_bar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(tool_bar);
        tool_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyDown();
            }
        });
        presenter.getSystemDatas();
    }


    @Override
    public void toast(String msg) {
        toastMsg(msg);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            presenter.onKeyDown();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setSystemData(ArrayList<SystemData> data) {
        if (adapter == null) {
            adapter = new WanSystemDataAdapter(data);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (adapter.getData().get(position) instanceof SystemData) {
                        SystemData systemData = (SystemData) adapter.getData().get(position);
                        presenter.onSystemClick(systemData, position);
                    }
                }
            });
        } else {
            adapter.setNewData(data);
        }
    }

    @Override
    public void finishView() {
        finish();
    }
}
