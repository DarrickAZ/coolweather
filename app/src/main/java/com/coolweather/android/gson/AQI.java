package com.coolweather.android.gson;

/**
 * @author Darrick
 * @package com.coolweather.android.gson
 * @class AQI
 * @date 2018/2/24 17:32
 * @description
 * @versions 1.0
 */
public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }

}
