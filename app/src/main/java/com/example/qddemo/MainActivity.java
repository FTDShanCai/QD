package com.example.qddemo;


import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.qd_base.BaseActivity;

public class MainActivity extends BaseActivity {
    TextView text;
    TextView tv_test;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        String[] permission = {Manifest.permission.PACKAGE_USAGE_STATS};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permission, 102);
        }
        text = findViewById(R.id.text);

        tv_test = findViewById(R.id.tv_test);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });
        tv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void goLogin() {
        ARouter.getInstance().build("/login/login").navigation(this, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.d("ftd", "onFound");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.d("ftd", "onLost");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.d("ftd", "onArrival");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.d("ftd", "onInterrupt");
            }
        });
    }

}
