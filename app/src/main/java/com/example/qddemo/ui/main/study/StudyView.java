package com.example.qddemo.ui.main.study;

import com.example.qd_base.mvp.BaseView;
import com.example.qddemo.bean.HomeBean;
import com.example.qddemo.bean.StudyBean;

import java.util.ArrayList;


/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public interface StudyView extends BaseView {
    void setHomeData(ArrayList<StudyBean> list);
}
