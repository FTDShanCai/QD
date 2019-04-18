package com.example.qd_base.net;

import com.example.qd_base.BaseApp;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class NoNetReadCacheClient extends BaseCacheClient {
    public NoNetReadCacheClient(OkHttpClient client) {
        super(client);
    }

    @Override
    public OkHttpClient getClient() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(BaseApp.getInstance().getCacheDir(), cacheSize);
        OkHttpClient.Builder builder = client.newBuilder();
        builder.cache(cache);
        builder.addNetworkInterceptor(new CacheNetworkInterceptor());
        return builder.build();
    }
}
