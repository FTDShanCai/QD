package com.example.qd_base.net;

import com.example.qd_base.AppStatus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class CacheInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response resp;
        Request req;
        if (AppStatus.isOnline) {
            //有网络,检查10秒内的缓存
            req = chain.request()
                    .newBuilder()
                    .cacheControl(new CacheControl
                            .Builder()
                            .maxAge(60, TimeUnit.MINUTES)
                            .build())
                    .build();
        } else {
            //无网络,检查30天内的缓存,即使是过期的缓存
            req = chain.request().newBuilder()
                    .cacheControl(new CacheControl.Builder()
                            .onlyIfCached()
                            .maxStale(30, TimeUnit.DAYS)
                            .build())
                    .build();
        }
        resp = chain.proceed(req);
        return resp.newBuilder().build();
    }
}