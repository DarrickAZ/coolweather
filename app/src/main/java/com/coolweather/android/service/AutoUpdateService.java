package com.coolweather.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import com.coolweather.android.constant.HttpUrl;
import com.coolweather.android.constant.ResponseStatus;
import com.coolweather.android.constant.UpConstant;
import com.coolweather.android.gson.Weather;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.ParseDataUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author Darrick
 * @description 后台自动更新天气信息
 */
public class AutoUpdateService extends Service {

    public AutoUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //更新天气信息
         updateWeather();
        //更新必应每日一图
         updateBingPic();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //8小时毫秒数
        int anHour = 8*60*60*1000;
        //int anHour = 5000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this,AutoUpdateService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        manager.cancel(pi);
        //设置定时任务
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 更新每日一图
     */
    private void updateBingPic() {
        String bicUrl = HttpUrl.API_BING_PIC;
        HttpUtil.sendOkHttpRequest(bicUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                editor.putString(UpConstant.BING_PIC,bingPic);
                editor.apply();
            }
        });

    }

    /**
     * 更新天气信息
     */
    private void updateWeather() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString(UpConstant.WEATHER, null);
        if(weatherString != null){
            //有缓存时直接解析天气数据
            Weather weather = ParseDataUtil.handleWeatherResponse(weatherString);
            String weatherId = weather.basic.weatherId;
            String weatherUrl = HttpUrl.API_WEATHER+"?cityid="+weatherId+"&key="+UpConstant.GUOLIN_KEY;
            HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseText = response.body().string();
                    Weather w = ParseDataUtil.handleWeatherResponse(responseText);
                    if(w!=null && ResponseStatus.OK.equals(w.status)){
                        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                        editor.putString(UpConstant.WEATHER,responseText);
                        editor.apply();
                    }
                }
            });
        }

    }
}
