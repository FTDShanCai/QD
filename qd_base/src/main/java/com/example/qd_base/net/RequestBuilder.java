package com.example.qd_base.net;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class RequestBuilder {

    private String url;
    private OkHttpClient httpClient;


    public RequestBuilder(String url, OkHttpClient httpClient) {
        this.url = url;
        this.httpClient = httpClient;

    }

    public RequestBuilder setCacheMode(CacheMode mode) {
        switch (mode) {
            case ReadCache:
                httpClient = new ReadCacheClient(httpClient).getClient();
                return this;
            case NoNetReadCache:
                httpClient = new NoNetReadCacheClient(httpClient).getClient();
                return this;
            case NoCache:
                httpClient = new NoCacheClient(httpClient).getClient();
                return this;
        }
        return this;
    }

    public <T> T getApi(final Class<T> service) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit= builder.build();
        return retrofit.create(service);
    }

}
