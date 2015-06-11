package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class AdvancedWebViewListener implements AdvancedWebView.Listener
{

    protected Context mAppContext;

    public AdvancedWebViewListener(Context mAppContext)
    {
        this.mAppContext = mAppContext;
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageFinished(String url)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDownloadRequested(String url, String userAgent, String contentDisposition, String mimetype, long contentLength)
    {
        // TODO Auto-generated method stub
        // some file is available for download
        // either handle the download yourself or use the code below

        final String filename = url.substring(url.lastIndexOf("/") + 1, url.length());
        // ...

        if (AdvancedWebView.handleDownload(mAppContext, url, filename))
        {
            // download successfully handled
            Log.d(mAppContext.getPackageName(), "download successfully");

        } else
        {
            // download couldn't be handled because user has disabled download manager app on the device
            // TODO show some notice to the user
        }
    }

    @Override
    public void onExternalPageRequest(String url)
    {
        // TODO Auto-generated method stub

    }

}
