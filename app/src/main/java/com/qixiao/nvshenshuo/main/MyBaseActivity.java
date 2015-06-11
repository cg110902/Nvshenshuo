package com.qixiao.nvshenshuo.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import com.handmark.pulltorefresh.library.AdvancedWebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

/**
 * Created by admin on 2015/6/10.
 */
public class MyBaseActivity extends ActionBarActivity implements OnRefreshListener<AdvancedWebView>, ContentValue
{

    protected ActionBarActivity mAppContext;

    protected  long exitTime=0;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        mAppContext = this;
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * 下拉松手后会被调用
     *
     * @param refreshView 刷新的View
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase<AdvancedWebView> refreshView)
    {

    }

    /**
     * 加载更多时会被调用或上拉时调用
     *
     * @param refreshView 刷新的View
     */
    @Override
    public void onPullUpToRefresh(PullToRefreshBase<AdvancedWebView> refreshView)
    {

    }
}
