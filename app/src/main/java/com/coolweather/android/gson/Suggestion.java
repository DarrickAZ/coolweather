package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author Darrick
 * @package com.coolweather.android.gson
 * @class Suggestion
 * @date 2018/2/24 17:36
 * @description
 * @versions 1.0
 */
public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }

}
