package com.qixiao.nvshenshuo;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.handmark.pulltorefresh.library.AdvancedWebView;
import com.handmark.pulltorefresh.library.AdvancedWebViewListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import com.qixiao.nvshenshuo.main.MyBaseActivity;


public class MainActivity extends MyBaseActivity {


    private PullToRefreshWebView mPullToRefreshWebView;
    private View mProgressBarView;

    private AdvancedWebView mWebView;
    private AdvancedWebViewListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPullToRefreshWebView = (PullToRefreshWebView) findViewById(R.id.pull_refresh_webview);
        mProgressBarView = findViewById(R.id.layout_progress);
        mListener = new AdvancedWebViewListener(mAppContext);

        mPullToRefreshWebView.setOnRefreshListener(this);
        mPullToRefreshWebView.setPullLoadEnabled(false);
        mWebView = mPullToRefreshWebView.getRefreshableView();
        mWebView.setListener(mAppContext, mListener);
        mWebView.setProgressBar(mProgressBarView);
        mWebView.setPullToRefreshWebView(mPullToRefreshWebView);
        mWebView.addJavascriptInterface(new JsBinding(), INTERFACE_NAME);
        mWebView.loadUrl("http://www.baidu.com/");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
                return true;

            } else {
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    exitTime = System.currentTimeMillis();
                } else {
                    finish();
                    return true;
                }

            }
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.onDestroy();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<AdvancedWebView> refreshView) {
        // TODO Auto-generated method stub
        super.onPullDownToRefresh(refreshView);
        mWebView.reload();
    }

    protected class JsBinding {

        @JavascriptInterface
        public void JsBindingMethod() {
        }

    }

}
