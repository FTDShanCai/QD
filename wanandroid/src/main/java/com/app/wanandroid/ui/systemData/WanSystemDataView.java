package com.app.wanandroid.ui.systemData;

import com.app.wanandroid.bean.SystemData;
import com.example.qd_base.mvp.BaseView;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WanSystemDataView extends BaseView {
    void  setSystemData(ArrayList<SystemData> data);

    void finishView();
}
