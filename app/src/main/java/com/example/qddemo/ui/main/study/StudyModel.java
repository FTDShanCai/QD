package com.example.qddemo.ui.main.study;

import com.example.qd_base.mvp.BaseModel;
import com.example.qddemo.R;
import com.example.qddemo.bean.HomeBean;
import com.example.qddemo.bean.HomeEnum;
import com.example.qddemo.bean.StudyBean;
import com.example.qddemo.bean.StudyEnum;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class StudyModel extends BaseModel<FragmentEvent> {


    public ArrayList<StudyBean> getHomeList() {
        ArrayList<StudyBean> list = new ArrayList<>();
        list.add(new StudyBean(StudyEnum.玩Android, "玩Android", R.mipmap.ic_launcher));
        return list;
    }
}
