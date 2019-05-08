package com.example.qd_base.mvp;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface ListView<T> {

    void initListData(ArrayList<T> list);

    void setRefreshLayoutEnable(boolean isLoadMore, boolean enable);

    void refreshOrLoadMoreComplete(boolean isRefresh);

    void notifyDataChange();

}
