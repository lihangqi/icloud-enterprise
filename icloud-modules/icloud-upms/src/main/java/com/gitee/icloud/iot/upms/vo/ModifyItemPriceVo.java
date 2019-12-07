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
public class ModifyItemPriceVo implements Serializable {

    private BigDecimal baseItemPrice;

    public BigDecimal getBaseItemPrice() {
        return baseItemPrice;
    }

    public void setBaseItemPrice(BigDecimal baseItemPrice) {
        this.baseItemPrice = baseItemPrice;
    }
}
