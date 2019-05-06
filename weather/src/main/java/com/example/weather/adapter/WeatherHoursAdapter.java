package com.example.weather.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.weather.R;
import com.example.weather.entity.WeatherResult;

import java.util.List;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WeatherHoursAdapter extends BaseQuickAdapter<WeatherResult.Data.Hours, BaseViewHolder> {
    public WeatherHoursAdapter(@Nullable List<WeatherResult.Data.Hours> data) {
        super(R.layout.weather_item_weather_hours, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherResult.Data.Hours item) {
        TextView tv_time = helper.getView(R.id.tv_time);
        TextView tv_temp = helper.getView(R.id.tv_temp);
        ImageView iv_icon = helper.getView(R.id.iv_icon);

        tv_time.setText(item.getDay());
        iv_icon.setImageResource(getIconId(item.getWea()));
        tv_temp.setText(item.getTem());
    }

    private int getIconId(String type) {
        if (type.equals("晴")) {
            return R.mipmap.ic_qing;
        } else if (type.equals("多云")) {
            return R.mipmap.ic_yun;
        } else if (type.equals("小雨") || type.equals("中雨") || type.equals("大雨")) {
            return R.mipmap.ic_yu;
        } else if (type.equals("小雪") || type.equals("中雪") || type.equals("大雪")) {
            return R.mipmap.ic_xue;
        } else if (type.equals("雨夹雪")) {
            return R.mipmap.ic_yujiaxue;
        } else if (type.contains("雾") || type.contains("霾")) {
            return R.mipmap.ic_wu;
        } else if (type.contains("雷")) {
            return R.mipmap.ic_lei;
        } else if (type.contains("沙")) {
            return R.mipmap.ic_shachen;
        } else if (type.contains("阴")) {
            return R.mipmap.ic_yin;
        } else if (type.contains("龙卷")) {
            return R.mipmap.ic_longjuanfeng;
        } else {
            return R.mipmap.ic_qing;
        }
    }

}
