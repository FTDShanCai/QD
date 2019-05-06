package com.example.weather.util;

import com.example.weather.R;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WeatherUtil {
    private WeatherUtil() {

    }

    public static int getWeatherBg(String type) {
        if (type.equals("xue")) {
            return R.mipmap.xue;
        } else if (type.equals("lei")) {
            return R.mipmap.lei;
        } else if (type.equals("shachen")) {
            return R.mipmap.shachen;
        } else if (type.equals("wu")) {
            return R.mipmap.wu;
        } else if (type.equals("bingbao")) {
            return R.mipmap.bingbao;
        } else if (type.equals("yun")) {
            return R.mipmap.yun;
        } else if (type.equals("yu")) {
            return R.mipmap.yu;
        } else if (type.equals("yin")) {
            return R.mipmap.yin;
        } else if (type.equals("qing")) {
            return R.mipmap.qing;
        } else {
            return R.mipmap.qing;
        }
    }

    public static int getWeatherIcon(String type) {
        if (type.equals("xue")) {
            return R.mipmap.ic_xue;
        } else if (type.equals("lei")) {
            return R.mipmap.ic_lei;
        } else if (type.equals("shachen")) {
            return R.mipmap.ic_shachen;
        } else if (type.equals("wu")) {
            return R.mipmap.ic_wu;
        } else if (type.equals("bingbao")) {
            return R.mipmap.ic_bingbao;
        } else if (type.equals("yun")) {
            return R.mipmap.ic_yun;
        } else if (type.equals("yu")) {
            return R.mipmap.ic_yu;
        } else if (type.equals("yin")) {
            return R.mipmap.ic_yin;
        } else if (type.equals("qing")) {
            return R.mipmap.ic_qing;
        } else {
            return R.mipmap.ic_qing;
        }
    }
}
