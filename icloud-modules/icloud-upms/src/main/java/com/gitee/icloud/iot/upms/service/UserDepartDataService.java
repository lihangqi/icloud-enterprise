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
package com.gitee.icloud.iot.upms.service;

import com.gitee.icloud.iot.common.data.IUserDepartDataService;
import com.gitee.icloud.iot.upms.biz.UserBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @FileName UserDepartDataService.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:25:59 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Component
public class UserDepartDataService implements IUserDepartDataService {
    @Autowired
    private UserBiz userFeign;
    @Override
    public List<String> getUserDataDepartIds(String userId) {
        // 获取用户授权的部门数据权限,此处模拟两个账户
        return userFeign.getUserDataDepartIds(userId);
    }
}
