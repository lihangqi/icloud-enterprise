package com.gitee.icloud.iot.upms.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * </p>
 *
 * @author wangxiaoqing
 * @since 2019/1/11
 */
public class AddTenantItemVo implements Serializable {

    private String tenantId;

    private Long baseItemId;

    private BigDecimal baseItemPrice;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBaseItemId() {
        return baseItemId;
    }

    public void setBaseItemId(Long baseItemId) {
        this.baseItemId = baseItemId;
    }

    public BigDecimal getBaseItemPrice() {
        return baseItemPrice;
    }

    public void setBaseItemPrice(BigDecimal baseItemPrice) {
        this.baseItemPrice = baseItemPrice;
    }
}
