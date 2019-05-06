package com.example.weather.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.mvp.BaseMvpActivity;
import com.example.weather.R;
import com.example.weather.adapter.WeatherHoursAdapter;
import com.example.weather.entity.WeatherResult;
import com.example.weather.util.WeatherUtil;

import java.util.ArrayList;

import butterknife.BindView;

@Route(path = ARouterConstants.WEATHER_MAIN)
public class WeatherMainActivity extends BaseMvpActivity<WeatherMainPresenter> implements WeatherMainView {
    @BindView(R.id.weather_bg)
    ImageView weatherBg;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.tv_temps)
    TextView tvTemps;
    @BindView(R.id.tv_air)
    TextView tvAir;
    @BindView(R.id.tv_air_lable)
    TextView tvAirLable;
    @BindView(R.id.tv_update_time)
    TextView tvUpdateTime;
    @BindView(R.id.recycler_hours)
    RecyclerView recyclerHours;
    @BindView(R.id.recycler_days)
    RecyclerView recyclerDays;

    @Override
    protected int getLayoutId() {
        return R.layout.weather_activity_main;
    }

    @Override
    protected void init() {
        presenter.getLocalWeather();
    }

    @Override
    protected WeatherMainPresenter getPresenter() {
        return new WeatherMainPresenter(this, this);
    }

    @Override
    public void toast(String msg) {
        toastMsg(msg);
    }

    @Override
    protected void beforeSetContentView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void setUpDateInfo(String city, String update_time) {
        tvArea.setText(city);
    }

    @Override
    public void setToDayData(WeatherResult.Data toDayData) {
        tvUpdateTime.setText("更新时间:\t\t" + toDayData.getDate() + "\t\t\t\t" + toDayData.getWeek());

        tvTemp.setText(toDayData.getTem().replace("℃", ""));
        tvWeather.setText(toDayData.getWea());
        tvTemps.setText(Html.fromHtml(toDayData.getTem1() + "<font color='#666666'>/" + toDayData.getTem2() + "</font>"));
        tvAir.setText(toDayData.getAir_level());
        tvAirLable.setText(toDayData.getAir_tips());

        //当日实时天气
        ArrayList<WeatherResult.Data.Hours> hours = toDayData.getHours();
        if (hours != null && hours.size() != 0) {
            recyclerHours.setVisibility(View.VISIBLE);
            recyclerHours.setFocusableInTouchMode(false);
            recyclerHours.requestFocus();
            WeatherHoursAdapter hoursAdapter = new WeatherHoursAdapter(hours);
            recyclerHours.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerHours.setAdapter(hoursAdapter);
            recyclerHours.setNestedScrollingEnabled(false);
        } else {
            recyclerHours.setVisibility(View.GONE);
        }

        weatherBg.setImageResource(WeatherUtil.getWeatherBg(toDayData.getWea_img()));
    }

    @Override
    public void setFutureDays(ArrayList<WeatherResult.Data> futureDays) {

    }
}
