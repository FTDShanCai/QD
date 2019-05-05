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

    private int maxAge_online = 60;
    private TimeUnit maxAge_timeUnit = TimeUnit.MINUTES;

    private int maxStale_offline = 30;
    private TimeUnit maxStale_timeUnit = TimeUnit.DAYS;

    public void setMaxAge(int maxAge_online,TimeUnit maxAge_timeUnit) {
        this.maxAge_online = maxAge_online;
        this.maxAge_timeUnit = maxAge_timeUnit;
    }

    public void setMaxStale(int maxStale_offline,TimeUnit maxStale_timeUnit) {
        this.maxStale_offline = maxStale_offline;
        this.maxStale_timeUnit = maxStale_timeUnit;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response resp;
        Request req;
        if (AppStatus.isOnline) {
            //有网络,检查10秒内的缓存
            req = chain.request()
                    .newBuilder()
                    .cacheControl(new CacheControl
                            .Builder()
                            .maxAge(maxAge_online, maxAge_timeUnit)
                            .build())
                    .build();
        } else {
            //无网络,检查30天内的缓存,即使是过期的缓存
            req = chain.request().newBuilder()
                    .cacheControl(new CacheControl.Builder()
                            .onlyIfCached()
                            .maxStale(maxStale_offline,maxStale_timeUnit)
                            .build())
                    .build();
        }
        resp = chain.proceed(req);
        return resp.newBuilder().build();
    }
}