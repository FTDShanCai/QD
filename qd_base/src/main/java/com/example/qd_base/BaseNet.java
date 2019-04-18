package com.example.qd_base;

import com.example.qd_base.net.RequestBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class BaseNet {

    private OkHttpClient httpClient;

    private static BaseNet net;

    public static BaseNet get() {
        if (net == null) {
            synchronized (BaseNet.class) {
                if (net == null) {
                    net = new BaseNet();
                }
            }
        }
        return net;
    }

    private BaseNet() {
        initDefaultHttpClient();
    }

    private void initDefaultHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.writeTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        httpClient = builder.build();
    }

    public void configOkHttpClient(OkHttpClient client) {
        this.httpClient = client;
    }

    public RequestBuilder api(String url) {
        RequestBuilder builder = new RequestBuilder(url, httpClient);
        return builder;
    }
}
