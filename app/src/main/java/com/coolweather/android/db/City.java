package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * @author Darrick
 * @package com.coolweather.android.db
 * @class City
 * @date 2018/2/24 14:23
 * @description city表
 * @versions 1.0
 */
public class City extends DataSupport {

    private int id;
    private String cityName;
    private int cityCode;
    /**
     * 当前市所属省的id值
     */
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
