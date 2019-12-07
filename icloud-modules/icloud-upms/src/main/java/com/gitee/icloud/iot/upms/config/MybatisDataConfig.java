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
package com.gitee.icloud.iot.upms.config;
import com.gitee.icloud.iot.common.data.IUserDepartDataService;
import com.gitee.icloud.iot.common.data.MybatisDataInterceptor;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
/**
 * @FileName MybatisDataConfig.java
 * @Description: 租户\部门数据隔离
 *
 * @Date Nov 28, 2018 6:58:30 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Configuration
public class MybatisDataConfig {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 该方法主要是为了让当前用户可以获取授权的数据权限部门
     */
    @Autowired
    private IUserDepartDataService userDepartDataService;

    @PostConstruct
    public void init(){
        /**
         * 有些mapper的某些方法不需要进行隔离，则可以在配置忽略，按逗号隔开.
         * 如:"com.gitee.icloud.iot.upms.mapper.UserMapper.selectOne",表示该mapper下不进行租户隔离
         */
        sqlSessionFactory.getConfiguration().addInterceptor(new MybatisDataInterceptor(userDepartDataService,"com.gitee.icloud.iot.upms.mapper.UserMapper.selectOne","com.gitee.icloud.iot.upms.mapper.UserMapper.selectByPrimaryKey"));
    }
}
