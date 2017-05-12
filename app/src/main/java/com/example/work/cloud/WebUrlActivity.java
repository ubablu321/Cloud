package com.example.work.cloud;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by prabhanjan on 3/28/2017.
 */

public class WebUrlActivity extends Activity {

    private WebView mywebview;
    private ProgressBar spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_url_act);

         mywebview=(WebView)findViewById(R.id.web_url_view);

        mywebview.setWebViewClient(new WebViewClient() {




        });

        if(getIntent() != null) {
            String url = getIntent().getStringExtra("url");
            WebSettings webSettings = mywebview.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mywebview.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    //hide loading image
                    findViewById(R.id.ll).setVisibility(View.GONE);
                    //show webview
                    findViewById(R.id.web_url_view).setVisibility(View.VISIBLE);
                }


            });
            mywebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mywebview.loadUrl(url);
        }
    }


    @Override
    public void onBackPressed() {
        if(mywebview.canGoBack()) {
            mywebview.goBack();
        } else {
            super.onBackPressed();
        }
    }




}
