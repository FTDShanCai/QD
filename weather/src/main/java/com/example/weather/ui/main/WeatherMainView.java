package com.example.weather.ui.main;

import com.example.qd_base.mvp.BaseView;
import com.example.weather.entity.WeatherResult;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface WeatherMainView extends BaseView {

    //设置更新信息
    void setUpDateInfo(String city, String update_time);

    //设置今天天气
    void setToDayData(WeatherResult.Data toDayData);

    //设置未来天气
    void setFutureDays(ArrayList<WeatherResult.Data> futureDays);
}
