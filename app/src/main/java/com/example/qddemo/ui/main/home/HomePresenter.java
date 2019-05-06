package com.example.qddemo.ui.main.home;

import android.content.Context;

import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.FragmentEvent;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class HomePresenter extends BasePresenter<HomeModel, HomeView, FragmentEvent> {

    public HomePresenter(Context context, HomeView view) {
        super(context, view);
    }

    @Override
    protected HomeModel getModel() {
        return new HomeModel();
    }

    public void getHomeData() {
        view.setHomeData(model.getHomeList());
    }

}
