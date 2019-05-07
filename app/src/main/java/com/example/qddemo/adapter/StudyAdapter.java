package com.example.qddemo.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.qddemo.R;
import com.example.qddemo.bean.HomeBean;
import com.example.qddemo.bean.StudyBean;

import java.util.List;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class StudyAdapter extends BaseQuickAdapter<StudyBean, BaseViewHolder> {

    public StudyAdapter(@Nullable List<StudyBean> data) {
        super(R.layout.item_home, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StudyBean item) {
        TextView tv_title = helper.getView(R.id.tv_title);
        tv_title.setText(item.getName());
    }
}
