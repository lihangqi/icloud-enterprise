package com.gitee.icloud.iot.upms.vo;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author wangxiaoqing
 * @since 2019/1/11
 */
public class AddTenantDeviceTypeVo implements Serializable {

    private String tenantId;

    private Long deviceType;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Long deviceType) {
        this.deviceType = deviceType;
    }
}
