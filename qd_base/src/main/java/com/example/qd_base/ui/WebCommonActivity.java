package com.example.qd_base.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.qd_base.R;
import com.example.qd_base.R2;
import com.example.qd_base.RxSchedulers;
import com.example.qd_base.arouter.ARouterConstants;
import com.example.qd_base.widget.LoadingDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.nio.file.WatchEvent;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

@Route(path = ARouterConstants.BASE_WEB)
public class WebCommonActivity extends RxAppCompatActivity implements View.OnClickListener {

    @BindView(R2.id.web_view)
    WebView web_view;
    @BindView(R2.id.tool_bar)
    Toolbar too_bar;
    @BindView(R2.id.progress)
    ProgressBar progress;
    @BindView(R2.id.tv_title)
    TextView tv_title;

    @Autowired()
    String url;

    @Autowired()
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_web_common);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        initTitle();
        initWeb();
    }


    private void initWeb() {
        progress.setMax(100);
        WebChromeClient client = new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress.setProgress(newProgress);
                if (newProgress == 100) {
                    Observable.timer(200, TimeUnit.MILLISECONDS)
                            .compose(RxSchedulers.compose())
                            .subscribe(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                    progress.setVisibility(View.GONE);
                                }
                            });

                } else {
                    progress.setVisibility(View.VISIBLE);
                }
            }

        };
        web_view.setWebChromeClient(client);
        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        web_view.getSettings().setJavaScriptEnabled(false);

        if (!TextUtils.isEmpty(url)) {
            web_view.loadUrl(url);
        }
    }

    private void initTitle() {
        too_bar.setTitle("");
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        } else {
            tv_title.setText("web");
        }
        tv_title.setSelected(true);
        tv_title.setOnClickListener(this);
        too_bar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(too_bar);
        too_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R2.id.tv_title:
                tv_title.setSelected(!tv_title.isSelected());
                break;
        }
    }
}
