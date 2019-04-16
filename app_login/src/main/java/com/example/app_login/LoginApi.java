package com.example.app_login;

import com.example.app_login.entity.LoginEntity;
import com.example.qd_base.BaseResult;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface LoginApi {

    @GET("wxarticle/chapters/json")
    Observable<BaseResult<ArrayList<LoginEntity>>> login();
}
