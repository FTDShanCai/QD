package com.example.weather.ui.main;

import android.content.Context;

import com.example.qd_base.BaseNet;
import com.example.qd_base.BaseResponse;
import com.example.qd_base.RxSchedulers;
import com.example.qd_base.mvp.BaseModel;
import com.example.weather.entity.WeatherResult;
import com.example.weather.net.WeatherApi;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WeatherModule extends BaseModel<ActivityEvent> {

    public void getWeather(Context context, BaseResponse<WeatherResult> response) {
        BaseNet.get().api(WeatherApi.url).getApi(WeatherApi.class)
                .getLocalWeather()
                .compose(RxSchedulers.<WeatherResult>compose())
                .compose(RxSchedulers.<WeatherResult>dialog(context))
                .compose(provider.<WeatherResult>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(response);
    }


}
