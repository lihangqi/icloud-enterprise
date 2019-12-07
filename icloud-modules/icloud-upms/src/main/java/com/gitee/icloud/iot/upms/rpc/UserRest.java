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
 * Nov 19, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.upms.rpc;
import com.gitee.icloud.core.context.BaseContextHandler;
import com.gitee.icloud.iot.api.vo.authority.PermissionInfo;
import com.gitee.icloud.iot.auth.client.annotation.CheckClientToken;
import com.gitee.icloud.iot.auth.client.annotation.CheckUserToken;
import com.gitee.icloud.iot.auth.client.annotation.IgnoreUserToken;
import com.gitee.icloud.iot.upms.rpc.service.PermissionService;
import com.icloud.cache.annotation.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 
 * @FileName UserRest.java
 * @Description: 
 *
 * @Date Nov 19, 2018 11:45:00 AM
 * @author Li.shangzhi
 * @version 1.0
 */
@RestController
@RequestMapping("api")
@CheckUserToken
@CheckClientToken
public class UserRest {
    @Autowired
    private PermissionService permissionService;

    @Cache(key="permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    @IgnoreUserToken
    public @ResponseBody
    List<PermissionInfo> getAllPermission(){
        return permissionService.getAllPermission();
    }

    @RequestMapping(value = "/user/permissions", method = RequestMethod.GET)
    public @ResponseBody List<PermissionInfo> getPermissionByUsername(){
        String username = BaseContextHandler.getUsername();
        return permissionService.getPermissionByUsername(username);
    }




}
