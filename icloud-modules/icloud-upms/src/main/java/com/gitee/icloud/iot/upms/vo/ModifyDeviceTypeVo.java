package com.gitee.icloud.iot.upms.vo;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author wangxiaoqing
 * @since 2019/1/11
 */
public class ModifyDeviceTypeVo implements Serializable {

    /**
     * 产品Flow
     */
    private String productFlows;

    public String getProductFlows() {
        return productFlows;
    }

    public void setProductFlows(String productFlows) {
        this.productFlows = productFlows;
    }
}
