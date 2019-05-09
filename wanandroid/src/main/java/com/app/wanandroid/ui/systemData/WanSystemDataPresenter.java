package com.app.wanandroid.ui.systemData;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.app.wanandroid.bean.SystemData;
import com.app.wanandroid.net.WanBaseResult;
import com.app.wanandroid.ui.articleList.WanArticleListActivity;
import com.app.wanandroid.util.Contacts;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanSystemDataPresenter extends BasePresenter<WanSystemDataModel, WanSystemDataView, ActivityEvent> {

    private ArrayList<Integer> integers = new ArrayList<>();

    private ArrayList<SystemData> systemData = new ArrayList<>();

    public WanSystemDataPresenter(Context context, WanSystemDataView view) {
        super(context, view);
    }

    @Override
    protected WanSystemDataModel getModel() {
        return new WanSystemDataModel();
    }

    public void getSystemDatas() {
        model.getSystemDatas(context.get(), new BaseResponse<WanBaseResult<ArrayList<SystemData>>>() {
            @Override
            protected void onSuccess(WanBaseResult<ArrayList<SystemData>> result, String msg) {
                systemData.clear();
                systemData.addAll(result.getData());
                view.setSystemData(systemData);
            }

            @Override
            protected void onError(String error) {
                view.toast(error);
            }
        });
    }

    public void onSystemClick(SystemData data, int nowPosition) {
        if (data.getChildren() != null && data.getChildren().size() != 0) {
            view.setSystemData(data.getChildren());
            integers.add(nowPosition);
        } else {
            ARouter.getInstance().build(ARouterConstants.Module.WanAndroid.WAN_ANDROID_ARTICLELIST)
                    .withString(Contacts.CID, data.getId())
                    .withString(Contacts.TITLE, data.getName())
                    .navigation();
        }
    }

    public void onKeyDown() {
        if (integers.size() == 0) {
            view.finishView();
        } else {
            integers.remove(integers.size() - 1);
            if (integers.size() == 0) {
                view.setSystemData(systemData);
            } else {
                SystemData backData = null;
                for (int i = 0; i < integers.size(); i++) {
                    backData = systemData.get(integers.get(i));
                }
                view.setSystemData(backData.getChildren());
            }
        }
    }
}
