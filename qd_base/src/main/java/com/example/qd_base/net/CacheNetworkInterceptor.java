package com.example.qd_base.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class CacheNetworkInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        //无缓存,进行缓存
        return chain.proceed(chain.request()).newBuilder()
                .removeHeader("Pragma")
                //对请求进行最大60秒的缓存
                .addHeader("Cache-Control", "max-age=60")
                .build();
    }
}