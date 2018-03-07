package com.coolweather.android.util;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author Darrick
 * @package com.coolweather.android.util
 * @class HttpUtil
 * @date 2018/2/24 14:32
 * @description HttpUtil网络相关工具类
 * @versions 1.0
 */
public class HttpUtil {

    private static final String TAG = "HttpUtil";

     public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
         Log.i(TAG,"url >>> "+address);
         OkHttpClient client = new OkHttpClient();
         Request request = new Request.Builder().url(address).build();
         client.newCall(request).enqueue(callback);
     }




}
