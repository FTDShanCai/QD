package com.example.qd_base.net;

import okhttp3.OkHttpClient;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public abstract class BaseCacheClient {

    protected OkHttpClient client;

    public BaseCacheClient(OkHttpClient client) {
        this.client = client;
    }

   public abstract OkHttpClient getClient();
}
