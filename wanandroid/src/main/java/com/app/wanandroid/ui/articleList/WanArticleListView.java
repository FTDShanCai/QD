package com.app.wanandroid.ui.articleList;

import com.app.wanandroid.bean.ArticleResult;
import com.example.qd_base.mvp.BaseView;
import com.example.qd_base.mvp.ListView;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WanArticleListView extends BaseView, ListView<ArticleResult.Data> {

    void setTitleBarInfo(String title);
}
