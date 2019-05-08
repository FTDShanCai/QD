package com.app.wanandroid.api;

import com.app.wanandroid.bean.ArticleResult;
import com.app.wanandroid.bean.BannerData;
import com.app.wanandroid.bean.SystemData;
import com.app.wanandroid.net.WanBaseResult;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WanApi {
    String url = "https://www.wanandroid.com/";

    //首页Banner
    @GET("banner/json")
    Observable<WanBaseResult<ArrayList<BannerData>>> getBanner();


    //文章列表
    @GET("article/listproject/{page}/json")
    Observable<WanBaseResult<ArticleResult>> getArticleProjectList(@Path("page") int page);


    //体系结构
    @GET("tree/json")
    Observable<WanBaseResult<ArrayList<SystemData>>> getSystemDatas();

}
