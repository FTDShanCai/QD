package com.example.weather.net;

import com.example.weather.entity.WeatherResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WeatherApi {
    String url = "https://www.tianqiapi.com";

    @GET("/api/?version=v1")
    Observable<WeatherResult> getLocalWeather();
}
