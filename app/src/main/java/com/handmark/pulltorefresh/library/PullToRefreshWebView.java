package com.handmark.pulltorefresh.library;


import android.content.Context;
import android.util.AttributeSet;
import android.util.FloatMath;

/**
 * 封装了WebView的下拉刷新
 *
 * @author Li Hong
 * @since 2013-8-22
 */
public class PullToRefreshWebView extends PullToRefreshBase<AdvancedWebView>
{
    /**
     * 构造方法
     *
     * @param context context
     */
    public PullToRefreshWebView(Context context)
    {
        this(context, null);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs   attrs
     */
    public PullToRefreshWebView(Context context, AttributeSet attrs)
    {
        //this(context, attrs, 0);
        super(context, attrs);
    }

    /**
     * 构造方法
     *
     * @param context context
     * @param attrs attrs
     * @param defStyle defStyle
     */
//    public PullToRefreshWebView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }

    /**
     * @see com.nj1s.lib.pullrefresh.PullToRefreshBase#createRefreshableView(Context,
     * AttributeSet)
     */
    @Override
    protected AdvancedWebView createRefreshableView(Context context, AttributeSet attrs)
    {
        AdvancedWebView webView = new AdvancedWebView(context);
        return webView;
    }

    /**
     * @see com.nj1s.lib.pullrefresh.PullToRefreshBase#isReadyForPullDown()
     */
    @Override
    protected boolean isReadyForPullDown()
    {
        return mRefreshableView.getScrollY() == 0;
    }

    /**
     * @see com.nj1s.lib.pullrefresh.PullToRefreshBase#isReadyForPullUp()
     */
    @Override
    protected boolean isReadyForPullUp()
    {

        float exactContentHeight = FloatMath.floor(mRefreshableView.getContentHeight() * mRefreshableView.getScale());
        return mRefreshableView.getScrollY() >= (exactContentHeight - mRefreshableView.getHeight());
    }
}
