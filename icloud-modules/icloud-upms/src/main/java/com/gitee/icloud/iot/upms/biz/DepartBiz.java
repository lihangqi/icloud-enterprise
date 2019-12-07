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
import com.alibaba.fastjson.JSONObject;
import com.gitee.icloud.core.context.BaseContextHandler;
import com.gitee.icloud.iot.common.biz.BusinessBiz;
import com.gitee.icloud.iot.common.exception.base.BusinessException;
import com.gitee.icloud.iot.common.msg.TableResultResponse;
import com.gitee.icloud.iot.common.util.UUIDUtils;
import com.gitee.icloud.iot.upms.entity.Depart;
import com.gitee.icloud.iot.upms.entity.User;
import com.gitee.icloud.iot.upms.mapper.DepartMapper;
import com.gitee.icloud.iot.upms.mapper.UserMapper;
import com.gitee.icloud.iot.upms.service.TableResultParser;
import com.gitee.icloud.merge.annonation.MergeResult;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @FileName DepartBiz.java
 * @Description: 
 *
 * @Date Nov 28, 2018 6:41:54 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Service
public class DepartBiz extends BusinessBiz<DepartMapper,Depart> {
    @Autowired
    private UserMapper userMapper;
    @MergeResult(resultParser = TableResultParser.class)
    public TableResultResponse<User> getDepartUsers(String departId,String userName) {
        List<User> users = this.mapper.selectDepartUsers(departId,userName);
        return new TableResultResponse<User>(users.size(),users);
    }

    public void addDepartUser(String departId, String userIds) {
        if (!StringUtils.isEmpty(userIds)) {
            String[] uIds = userIds.split(",");
            for (String uId : uIds) {
                this.mapper.insertDepartUser(UUIDUtils.generateUuid(),departId,uId, BaseContextHandler.getTenantID());
            }
        }
    }

    /**
     * 根据ID批量获取部门值
     * @param departIDs
     * @return
     */
    public Map<String,String> getDeparts(String departIDs){
        if(StringUtils.isBlank(departIDs)) {
            return new HashMap<>();
        }
        departIDs = "'"+departIDs.replaceAll(",","','")+"'";
        List<Depart> departs = mapper.selectByIds(departIDs);
        return departs.stream().collect(Collectors.toMap(Depart::getId, depart -> JSONObject.toJSONString(depart)));
    }

    public void delDepartUser(String departId, String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(user.getDepartId().equals(departId)){
            throw new BusinessException("无法移除用户的默认关联部门,若需移除,请前往用户模块更新用户部门!");
        }
        this.mapper.deleteDepartUser(departId,userId);
    }

    @Override
    public void insertSelective(Depart entity) {
        entity.setId(UUIDUtils.generateUuid());
        super.insertSelective(entity);
    }
}