package com.example.qd_base.mvp;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public abstract class BaseMvpFragment<P extends BasePresenter> extends RxFragment {
    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract P getPresenter();

    protected View rootView;

    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, rootView);
        Log.d("ftd", "onCreateView");
        if (presenter == null) {
            presenter = getPresenter();
        }
        if (presenter != null) {
            presenter.setProvider(this);
        }

        getLifecycle().addObserver((GenericLifecycleObserver) (source, event) -> {
            if (event == Lifecycle.Event.ON_DESTROY && presenter != null) {
                presenter.destory();
            }
        });
        init();
        return rootView;
    }

    public void toastMsg(String msg) {
        if (TextUtils.isEmpty(msg))
            return;
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
