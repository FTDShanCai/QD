package com.example.qddemo.ui.main.study;

import android.content.Context;

import com.example.qd_base.mvp.BasePresenter;
import com.trello.rxlifecycle2.android.FragmentEvent;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class StudyPresenter extends BasePresenter<StudyModel, StudyView, FragmentEvent> {

    public StudyPresenter(Context context, StudyView view) {
        super(context, view);
    }

    @Override
    protected StudyModel getModel() {
        return new StudyModel();
    }

    public void getHomeData() {
        view.setHomeData(model.getHomeList());
    }

}
