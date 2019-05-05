package com.example.app_login.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.app_login.R;
import com.example.app_login.lifecycle.LifecycleListener;
import com.example.qd_base.RxSchedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class LifecycleActivity extends AppCompatActivity {
    private TextView tv_text, tv_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        tv_text = findViewById(R.id.tv_text);
        tv_text2 = findViewById(R.id.tv_text2);

        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        tv_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifecycleActivity.this, Test2Activity.class));
            }
        });
    }

    private final String LIFE = "lf";

    private void test() {
        FragmentManager manager = getSupportFragmentManager();

        boolean isADD = false;
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null && fragments.size() != 0) {
            for (Fragment frg : fragments) {
                if (LIFE.equals(frg.getTag())) {
                    Log.d("ftd", "fragment： 已经存在  | " + fragments.size());
                    isADD = true;
                }
            }
        }
        if (!isADD) {
            FragmentTransaction ft = manager.beginTransaction();
            LifecycleFragment fragment = new LifecycleFragment();
            fragment.setListener(new LifecycleListener() {
                @Override
                public void onStart() {
                    Log.d("ftd", "onStart");
                }

                @Override
                public void onStop() {
                    Log.d("ftd", "onStop");
                }

                @Override
                public void onDestory() {
                    Log.d("ftd", "onDestory");
                }
            });
            ft.add(fragment, LIFE).commitAllowingStateLoss();
        }

    }
}
