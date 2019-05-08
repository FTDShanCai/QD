package com.app.wanandroid.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.wanandroid.R;
import com.app.wanandroid.bean.SystemData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.ktdemo.util.RandomUtil;

import java.util.List;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanSystemDataAdapter extends BaseQuickAdapter<SystemData, BaseViewHolder> {

    public WanSystemDataAdapter(@Nullable List<SystemData> data) {
        super(R.layout.wan_item_system_data, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemData item) {
        TextView tv_lable = helper.getView(R.id.tv_lable);
        RelativeLayout re_bg = helper.getView(R.id.re_bg);
        tv_lable.setText(item.getName());

        re_bg.setBackgroundResource(RandomUtil.Companion.getColor(helper.getAdapterPosition()));
    }
}
