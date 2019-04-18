package com.example.qd_base.net;

import okhttp3.OkHttpClient;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class NoCacheClient extends BaseCacheClient {
    public NoCacheClient(OkHttpClient client) {
        super(client);
    }

    @Override
    public OkHttpClient getClient() {
        OkHttpClient.Builder builder = client.newBuilder();
        return builder.build();
    }
}
