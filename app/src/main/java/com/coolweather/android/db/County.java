package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * @author Darrick
 * @package com.coolweather.android.db
 * @class County
 * @date 2018/2/24 14:24
 * @description county表
 * @versions 1.0
 */
public class County extends DataSupport {

    private int id;
    private String countyName;
    private String weatherId;
    /**
     * 当前县所属市的id值
     */
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
