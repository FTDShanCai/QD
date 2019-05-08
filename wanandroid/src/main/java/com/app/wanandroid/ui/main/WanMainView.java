package com.app.wanandroid.ui.main;

import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.bean.BannerData;
import com.example.qd_base.mvp.BaseView;
import com.example.qd_base.mvp.ListView;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WanMainView extends BaseView, ListView<ArticleResult.Data> {

    void setBanner(ArrayList<BannerData> banner,   ArrayList<String> desc);

}
