package com.app.wanandroid.ui.usuallyNet;

import com.app.wanandroid.bean.UsuallyNetData;
import com.example.qd_base.mvp.BaseView;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WanUsuallyNetView extends BaseView {

    void setUsuallyNetData(ArrayList<UsuallyNetData> list);
}
