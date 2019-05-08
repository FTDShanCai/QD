package com.app.wanandroid.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.wanandroid.R;
import com.app.wanandroid.bean.ArticleResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.ktdemo.util.RandomUtil;
import com.example.qd_base.util.GlideUtil;

import java.util.List;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WanListAdapter extends BaseQuickAdapter<ArticleResult.Data, BaseViewHolder> {

    public WanListAdapter(@Nullable List<ArticleResult.Data> data) {
        super(R.layout.wan_item_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleResult.Data item) {
        ImageView img = helper.getView(R.id.img);
        CardView cardImg = helper.getView(R.id.card_img);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvLable = helper.getView(R.id.tv_lable);
        CardView cardLable = helper.getView(R.id.card_lable);
        TextView tvDate = helper.getView(R.id.tv_date);
        int color = RandomUtil.Companion.getColor();
        cardImg.setCardBackgroundColor(color);

        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            img.setVisibility(View.VISIBLE);
            GlideUtil.load(mContext, item.getEnvelopePic(), img);
        } else {
            img.setVisibility(View.GONE);
        }

        tvTitle.setText(item.getTitle());
        tvLable.setText(item.getAuthor());
        cardLable.setCardBackgroundColor(color);
        tvDate.setText(item.getNiceDate());
    }
}
