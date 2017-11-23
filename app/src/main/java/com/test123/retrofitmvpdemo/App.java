package com.test123.retrofitmvpdemo;

import android.app.Application;
import android.content.Context;

import com.test123.retrofitmvpdemo.manager.ApiManager;


/**
 * Created by pankaj on 22/11/17.
 */

public class App extends Application {

    private static ApiManager sApiManager;
    private static Context mCOntext;

    @Override
    public void onCreate() {
        super.onCreate();

        mCOntext = getApplicationContext();
    }


    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
            sApiManager.init(mCOntext);
        }
        return sApiManager;
    }


}
