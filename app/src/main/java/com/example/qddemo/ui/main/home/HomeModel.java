package com.example.qddemo.ui.main.home;

import com.example.qd_base.mvp.BaseModel;
import com.example.qddemo.R;
import com.example.qddemo.bean.HomeBean;
import com.example.qddemo.bean.HomeEnum;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class HomeModel extends BaseModel<FragmentEvent> {


    public ArrayList<HomeBean> getHomeList() {
        ArrayList<HomeBean> list = new ArrayList<>();
        list.add(new HomeBean(HomeEnum.天气, "天气", R.mipmap.ic_launcher));
        return list;
    }
}
