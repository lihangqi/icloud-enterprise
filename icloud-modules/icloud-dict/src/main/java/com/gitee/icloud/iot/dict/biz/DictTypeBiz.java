/*
 * COPYRIGHT. ShenZhen Li.Shangzhi  2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen Li.Shangzhi
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Nov 12, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.dict.biz;

import com.gitee.icloud.iot.common.biz.BusinessBiz;
import com.gitee.icloud.iot.common.util.UUIDUtils;
import com.gitee.icloud.iot.dict.entity.DictType;
import com.gitee.icloud.iot.dict.mapper.DictTypeMapper;

import org.springframework.stereotype.Service;

/**
 * @FileName DictTypeBiz.java
 * @Description: 
 *
 * @Date Nov 12, 2018 9:12:23 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Service
public class DictTypeBiz extends BusinessBiz<DictTypeMapper,DictType> {
    @Override
    public void insertSelective(DictType entity) {
        entity.setId(UUIDUtils.generateUuid());
        super.insertSelective(entity);
    }
}