package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author Darrick
 * @package com.coolweather.android.gson
 * @class Forecast
 * @date 2018/2/24 17:39
 * @description
 * @versions 1.0
 */
public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    private class Temperature {
        public String max;
        public String min;
    }

    private class More {
        @SerializedName("txt_d")
        public String info;
    }
}
