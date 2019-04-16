package com.example.qd_base.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;

import com.example.qd_base.R;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class LoadingDialog extends BaseDialog {
    ContentLoadingProgressBar progress;

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.base_dialog_loading;
    }

    @Override
    protected void init(View view) {
        progress =view.findViewById(R.id.progress);
        progress.show();
    }
}
