package com.example.qd_base.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;

public abstract class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        super(context);
        initLayoutRes();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initLayoutRes();
    }


    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void init(View view);


    private void initLayoutRes() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
        ButterKnife.bind(this, view);
        setContentView(view);
        init(view);
    }

    protected void initDisplay(double d) {
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int) (display.getWidth() * d); //设置宽度
        getWindow().setAttributes(lp);
    }

    protected void safeDismiss() {
        if (isShowing()) {
            dismiss();
        }
    }


    //    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        if (!hasFocus) {
//            return;
//        }
//        setHeight();
//    }
//
//    private void setHeight() {
//        Window window = getWindow();
//        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        if (window.getDecorView().getHeight() >= (int) (displayMetrics.heightPixels * 0.6)) {
//            attributes.height = (int) (displayMetrics.heightPixels * 0.6);
//        }
//        window.setAttributes(attributes);
//    }
}
