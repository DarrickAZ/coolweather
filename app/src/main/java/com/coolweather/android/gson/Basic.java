package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author Darrick
 * @package com.coolweather.android.gson
 * @class Basic
 * @date 2018/2/24 17:26
 * @description Basic类 @SerializedName解决了Gson和Model不对称的问题
 * @versions 1.0
 */
public class Basic {

    /**
     * 使用@Serialized注解来让JSON字段和Java字段之间建立映射关系
     */
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;

    }

}
