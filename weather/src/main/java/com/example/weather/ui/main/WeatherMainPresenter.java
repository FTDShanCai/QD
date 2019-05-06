package com.example.weather.ui.main;

import android.content.Context;

import com.example.qd_base.BaseResponse;
import com.example.qd_base.mvp.BasePresenter;
import com.example.weather.entity.WeatherResult;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WeatherMainPresenter extends BasePresenter<WeatherModule, WeatherMainView, ActivityEvent> {

    public WeatherMainPresenter(Context context, WeatherMainView view) {
        super(context, view);
    }

    @Override
    protected WeatherModule getModel() {
        return new WeatherModule();
    }

    public void getLocalWeather() {
        model.getWeather(context.get(), new BaseResponse<WeatherResult>() {
            @Override
            protected void onSuccess(WeatherResult weatherResult, String msg) {

                if (weatherResult == null) {
                    view.toast("错误数据");
                    return;
                }

                view.setUpDateInfo(weatherResult.getCity(), weatherResult.getUpdate_time());

                if (weatherResult.getData() != null && weatherResult.getData().size() != 0) {
                    view.setToDayData(weatherResult.getData().get(0));
                }

                if (weatherResult.getData() != null && weatherResult.getData().size() > 1) {
                    ArrayList<WeatherResult.Data> futureDays = new ArrayList<>();
                    futureDays.addAll(weatherResult.getData().subList(1, weatherResult.getData().size()));
                    view.setFutureDays(futureDays);
                }
            }

            @Override
            protected void onError(String error) {
                view.toast(error);
            }
        });

    }
}
