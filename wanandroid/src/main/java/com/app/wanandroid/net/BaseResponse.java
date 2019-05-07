package com.app.wanandroid.net;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public abstract class BaseResponse<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        if (t instanceof WanBaseResult) {
            WanBaseResult result = (WanBaseResult) t;
            if (result.getErrorCode() == 0) {
                onSuccess(t, "成功");
            } else {
                onError(result.getErrorMsg());
            }
        } else {
            onSuccess(t, "成功");
        }

    }

    @Override
    public void onError(Throwable e) {
        onError(e.toString());
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t, String msg);

    protected abstract void onError(String error);
}
