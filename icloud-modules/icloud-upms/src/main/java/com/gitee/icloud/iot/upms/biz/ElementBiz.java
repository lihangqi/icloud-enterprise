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
 * Nov 28, 2018    Li.shangzhi         Create the class
*/

package com.gitee.icloud.iot.upms.biz;

import com.gitee.icloud.iot.common.biz.BusinessBiz;
import com.gitee.icloud.iot.common.util.BooleanUtil;
import com.gitee.icloud.iot.upms.constant.AdminCommonConstant;
import com.gitee.icloud.iot.upms.entity.Element;
import com.gitee.icloud.iot.upms.mapper.ElementMapper;
import com.gitee.icloud.iot.upms.mapper.UserMapper;
import com.gitee.icloud.merge.annonation.MergeResult;
import com.icloud.cache.annotation.Cache;
import com.icloud.cache.annotation.CacheClear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 
 * @FileName ElementBiz.java
 * @Description: 
 *
 * @Date Nov 19, 2018 9:59:08 AM
 * @author Li.shangzhi
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementBiz extends BusinessBiz<ElementMapper,Element> {
    @Autowired
    private UserMapper userMapper;
    /**
     * 获取用户可以访问的资源
     * @param userId
     * @return
     */
    @Cache(key="permission:ele:u{1}")
    public List<Element> getAuthorityElementByUserId(String userId){
        if(BooleanUtil.BOOLEAN_TRUE.equals(userMapper.selectByPrimaryKey(userId).getIsSuperAdmin())){
            return mapper.selectAllElementPermissions();
        }
       return mapper.selectAuthorityElementByUserId(userId,AdminCommonConstant.RESOURCE_TYPE_VIEW);
    }

    public List<Element> getAuthorityElementByUserId(String userId,String menuId){
        return mapper.selectAuthorityMenuElementByUserId(userId,menuId,AdminCommonConstant.RESOURCE_TYPE_VIEW);
    }

    @Cache(key="permission:ele")
    public List<Element> getAllElementPermissions(){
        return mapper.selectAllElementPermissions();
    }

    @Override
    @CacheClear(keys={"permission:ele","permission"})
    public void insertSelective(Element entity) {
        super.insertSelective(entity);
    }

    @Override
    @CacheClear(keys={"permission:ele","permission"})
    public void updateSelectiveById(Element entity) {
        super.updateSelectiveById(entity);
    }

    @MergeResult
    @Override
    public List<Element> selectByExample(Object example) {
        return super.selectByExample(example);
    }
}
