package com.example.qd_base.mvp;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends RxAppCompatActivity {
    protected abstract int getLayoutId();

    protected abstract P getPresenter();

    protected P presenter;

    protected abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
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
    }

    public void toastMsg(String msg) {
        if (TextUtils.isEmpty(msg))
            return;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    protected void beforeSetContentView() {

    }
}
