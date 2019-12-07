package com.gitee.icloud.iot.upms.vo;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author wangxiaoqing
 * @since 2019/1/11
 */
public class AddItemVo implements Serializable {

    private String baseItemName;

    private Integer baseItemType;

    private Long baseItemCapacity;

    private Long productId;

    private Long speedPolicyId;

    private String baseItemDesc;

    public String getBaseItemName() {
        return baseItemName;
    }

    public void setBaseItemName(String baseItemName) {
        this.baseItemName = baseItemName;
    }

    public Integer getBaseItemType() {
        return baseItemType;
    }

    public void setBaseItemType(Integer baseItemType) {
        this.baseItemType = baseItemType;
    }

    public Long getBaseItemCapacity() {
        return baseItemCapacity;
    }

    public void setBaseItemCapacity(Long baseItemCapacity) {
        this.baseItemCapacity = baseItemCapacity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSpeedPolicyId() {
        return speedPolicyId;
    }

    public void setSpeedPolicyId(Long speedPolicyId) {
        this.speedPolicyId = speedPolicyId;
    }

    public String getBaseItemDesc() {
        return baseItemDesc;
    }

    public void setBaseItemDesc(String baseItemDesc) {
        this.baseItemDesc = baseItemDesc;
    }
}
