package com.gitee.icloud.iot.upms.vo;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author wangxiaoqing
 * @since 2019/1/11
 */
public class ModifyBaseItemVo implements Serializable {

    private String baseItemName;

    private Long speedPolicyId;

    public String getBaseItemName() {
        return baseItemName;
    }

    public void setBaseItemName(String baseItemName) {
        this.baseItemName = baseItemName;
    }

    public Long getSpeedPolicyId() {
        return speedPolicyId;
    }

    public void setSpeedPolicyId(Long speedPolicyId) {
        this.speedPolicyId = speedPolicyId;
    }
}
