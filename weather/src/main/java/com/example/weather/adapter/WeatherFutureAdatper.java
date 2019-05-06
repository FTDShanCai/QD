package com.example.weather.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.weather.R;
import com.example.weather.entity.WeatherResult;
import com.example.weather.util.WeatherUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WeatherFutureAdatper extends BaseQuickAdapter<WeatherResult.Data, BaseViewHolder> {
    private SimpleDateFormat sdf;

    public WeatherFutureAdatper(@Nullable List<WeatherResult.Data> data) {
        super(R.layout.weather_item_future, data);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherResult.Data item) {
        TextView tv_date = helper.getView(R.id.tv_date);
        CircleImageView iv_icon = helper.getView(R.id.iv_icon);
        TextView tv_temps = helper.getView(R.id.tv_temps);
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(item.getDate()));
            int mouth = calendar.get(Calendar.MONTH) + 1;
            tv_date.setText(mouth + "月" + item.getDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        iv_icon.setImageResource(WeatherUtil.getWeatherIcon(item.getWea_img()));
        tv_temps.setText(Html.fromHtml(item.getTem1() + "<font color='#666666'>/" + item.getTem2() + "</font>"));
    }

}
