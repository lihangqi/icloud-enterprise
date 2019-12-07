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
package com.gitee.icloud.iot.upms.rest;
import com.gitee.icloud.iot.auth.client.annotation.CheckClientToken;
import com.gitee.icloud.iot.auth.client.annotation.CheckUserToken;
import com.gitee.icloud.iot.common.msg.ObjectRestResponse;
import com.gitee.icloud.iot.common.msg.TableResultResponse;
import com.gitee.icloud.iot.common.rest.BaseController;
import com.gitee.icloud.iot.common.util.TreeUtil;
import com.gitee.icloud.iot.upms.biz.DepartBiz;
import com.gitee.icloud.iot.upms.entity.Depart;
import com.gitee.icloud.iot.upms.entity.User;
import com.gitee.icloud.iot.upms.vo.DepartTree;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @FileName DepartController.java
 * @Description: 
 *
 * @Date Dec 17, 2018 3:49:19 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@RestController
@RequestMapping("depart")
@CheckClientToken
@CheckUserToken
@Api(tags = "部门管理")
public class DepartController extends BaseController<DepartBiz,Depart,String> {
    @ApiOperation("获取部门树")
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public List<DepartTree> getTree() {
        List<Depart> departs = this.baseBiz.selectListAll();
        List<DepartTree> trees = new ArrayList<>();
        departs.forEach(dictType -> {
            trees.add(new DepartTree(dictType.getId(), dictType.getParentId(), dictType.getName(),dictType.getCode()));
        });
        return TreeUtil.bulid(trees, "-1", null);
    }
    @ApiOperation("获取部门关联用户")
    @RequestMapping(value = "user",method = RequestMethod.GET)
    public TableResultResponse<User> getDepartUsers(String departId,String userName){
        return this.baseBiz.getDepartUsers(departId,userName);
    }

    @ApiOperation("部门添加用户")
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public ObjectRestResponse<Boolean> addDepartUser(String departId, String userIds){
        this.baseBiz.addDepartUser(departId,userIds);
        return new ObjectRestResponse<>().data(true);
    }

    @ApiOperation("部门移除用户")
    @RequestMapping(value = "user",method = RequestMethod.DELETE)
    public ObjectRestResponse<Boolean> delDepartUser(String departId,String userId){
        this.baseBiz.delDepartUser(departId,userId);
        return new ObjectRestResponse<>().data(true);
    }

    @ApiOperation("获取部门信息")
    @RequestMapping(value = "getByPK/{id}",method = RequestMethod.GET)
    public Map<String,String> getDepart(@PathVariable String id){
        return this.baseBiz.getDeparts(id);
    }

}