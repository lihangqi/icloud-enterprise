package com.gitee.icloud.iot.upms.vo;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author wangxiaoqing
 * @since 2019/1/11
 */
public class AddDeviceTypeVo implements Serializable {

    private String deviceTypeName;

    private String productFlows;

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getProductFlows() {
        return productFlows;
    }

    public void setProductFlows(String productFlows) {
        this.productFlows = productFlows;
    }
}
