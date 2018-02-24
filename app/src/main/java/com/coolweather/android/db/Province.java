package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * @author Darrick
 * @package com.coolweather.android.db
 * @class Province
 * @date 2018/2/24 14:20
 * @description province表
 * @versions 1.0
 */
public class Province extends DataSupport {

    private int id;
    private String provinceName;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
