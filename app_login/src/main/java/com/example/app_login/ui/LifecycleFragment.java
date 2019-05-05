package com.example.app_login.ui;

import android.support.v4.app.Fragment;

import com.example.app_login.lifecycle.LifecycleListener;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class LifecycleFragment extends Fragment {
    private LifecycleListener listener;

    public void setListener(LifecycleListener listener) {
        this.listener = listener;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (listener != null) {
            listener.onDestory();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (listener != null) {
            listener.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (listener != null) {
            listener.onStop();
        }
    }
}
