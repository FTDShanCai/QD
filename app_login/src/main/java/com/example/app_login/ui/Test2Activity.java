package com.example.app_login.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.app_login.R;
import com.example.app_login.lifecycle.LifecycleListener;
import com.example.qd_base.RxSchedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        findViewById(R.id.tv_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
    }

    private void test() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        LifecycleFragment fragment = new LifecycleFragment();
        fragment.setListener(new LifecycleListener() {
            @Override
            public void onStart() {
                Log.d("ftd", "onStart2");
            }

            @Override
            public void onStop() {
                Log.d("ftd", "onStop2");
            }

            @Override
            public void onDestory() {
                Log.d("ftd", "onDestory2");
            }
        });

        ft.add(fragment, "lf").commitAllowingStateLoss();



        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .compose(RxSchedulers.compose())
                .compose(RxSchedulers.dialog(this))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        List<Fragment> fragments = getSupportFragmentManager().getFragments();
                        Log.d("ftd", "size | " + fragments.size());
                    }
                });


    }
}
