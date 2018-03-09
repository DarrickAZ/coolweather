package com.coolweather.android.app;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

/**
 * @author Darrick
 * @package com.coolweather.android.app
 * @class CoolWeatherApplication
 * @date 2018/3/9 17:05
 * @description
 * @versions 1.0
 */
public class CoolWeatherApplication extends Application {

    private static final String TAG = "CoolWeatherApplication";

    private static Context context;

    private LocalBroadcastManager localBroadcastManager;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //初始化LitePal
        LitePal.initialize(this);
        Connector.getDatabase();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    public static Context getContext() {
        return context;
    }

    public void sendLocalBroadcast(Intent intent){
        localBroadcastManager.sendBroadcast(intent);
    }

//    public LocalBroadcastManager getLocalBroadcastManager() {
//        return localBroadcastManager;
//    }

    public void registerLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver, IntentFilter filter){
        localBroadcastManager.registerReceiver(broadcastReceiver, filter);
    }

    public void unregisterLocalBroadcastReceiver(BroadcastReceiver broadcastReceiver){
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

}
