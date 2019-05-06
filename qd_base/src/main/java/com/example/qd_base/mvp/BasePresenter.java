package com.example.qd_base.mvp;

import android.content.Context;
import android.view.View;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.SoftReference;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public abstract class BasePresenter<M extends BaseModel, V extends BaseView, T> {

    protected LifecycleProvider<T> provider;

    protected M model;

    protected V view;

    protected abstract M getModel();


    protected SoftReference<Context> context;

    public BasePresenter(Context context, V view) {
        if (context == null)
            throw new IllegalStateException("Context is null");
        this.context = new SoftReference<>(context);
        if (model == null) {
            model = getModel();
        }

        if (this.view == null) {
            this.view = view;
        }
    }

    public void setProvider(LifecycleProvider<T> provider) {
        this.provider = provider;

        if (model!=null){
            model.setProvider(provider);
        }
    }

    public void destory() {
        view = null;
        model = null;
        context.clear();
        context = null;
    }

}
