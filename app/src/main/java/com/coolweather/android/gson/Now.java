package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author Darrick
 * @package com.coolweather.android.gson
 * @class Now
 * @date 2018/2/24 17:34
 * @description
 * @versions 1.0
 */
public class Now {

    /**
     * 使用@Serialized注解来让JSON字段和Java字段之间建立映射关系
     */
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }

}
