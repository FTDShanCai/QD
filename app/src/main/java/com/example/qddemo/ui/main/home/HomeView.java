package com.example.qddemo.ui.main.home;

import com.example.qd_base.mvp.BaseView;
import com.example.qddemo.bean.HomeBean;

import java.util.ArrayList;


/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface HomeView extends BaseView {
    void setHomeData(ArrayList<HomeBean> list);
}
