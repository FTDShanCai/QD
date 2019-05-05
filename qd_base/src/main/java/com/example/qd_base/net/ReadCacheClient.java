package com.example.qd_base.net;

import com.example.qd_base.BaseApp;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class ReadCacheClient extends BaseCacheClient {

    private CacheInterceptor cacheInterceptor;

    public void setCacheInterceptor(CacheInterceptor cacheInterceptor) {
        this.cacheInterceptor = cacheInterceptor;
    }

    public ReadCacheClient(OkHttpClient client) {
        super(client);
        cacheInterceptor = new CacheInterceptor();
    }

    public void setMaxAge(int maxAge_online, TimeUnit maxAge_timeUnit) {
        cacheInterceptor.setMaxAge(maxAge_online, maxAge_timeUnit);
    }

    public void setMaxStale(int maxStale_offline, TimeUnit maxStale_timeUnit) {
        cacheInterceptor.setMaxStale(maxStale_offline, maxStale_timeUnit);
    }

    @Override
    public OkHttpClient getClient() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(BaseApp.getInstance().getCacheDir(), cacheSize);
        OkHttpClient.Builder builder = client.newBuilder();
        builder.cache(cache);
        builder.addInterceptor(new CacheInterceptor());
        builder.addNetworkInterceptor(new CacheNetworkInterceptor());
        return builder.build();
    }
}
