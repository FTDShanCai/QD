package com.example.qd_base.mvp;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class BaseModel<T> {
    protected LifecycleProvider<T> provider;

    public BaseModel() {
    }

    public void setProvider(LifecycleProvider<T> provider) {
        this.provider = provider;
    }
}
