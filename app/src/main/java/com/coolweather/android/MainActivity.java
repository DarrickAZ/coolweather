package com.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coolweather.android.constant.UpConstant;
import com.coolweather.android.util.MailHandler;
import com.coolweather.android.util.PrintStackTraceUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            //根据判断，显示初始化实在选择省份页面，还是显示天气信息的页面
            if(prefs.getString(UpConstant.WEATHER,null)!=null){
                Intent intent = new Intent(this,WeatherActivity.class);
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
            //测试发送邮件
            String msg = PrintStackTraceUtil.getMessage(e);
            new Thread(new MailHandler(msg)).start();
        }
    }
}
