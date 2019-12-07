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
package com.gitee.icloud.iot.upms.mapper;
import com.gitee.icloud.iot.common.mapper.CommonMapper;
import com.gitee.icloud.iot.upms.entity.Menu;

import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @FileName MenuMapper.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:20:59 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public interface MenuMapper extends CommonMapper<Menu> {
    /**
     * 根据资源类型查询菜单
     * @param authorityId
     * @param authorityType
     * @param type
     * @return
     */
    public List<Menu> selectMenuByAuthorityId(@Param("authorityId") String authorityId, @Param("authorityType") String authorityType, @Param("type") String type);

    /**
     * 根据用户和组的权限关系查找用户可访问菜单
     *
     * @param userId
     * @return
     */
    public List<Menu> selectAuthorityMenuByUserId(@Param("userId") String userId, @Param("type") String type);

    /**
     * 根据用户和组的权限关系查找用户可访问的系统
     *
     * @param userId
     * @return
     */
    public List<Menu> selectAuthoritySystemByUserId(@Param("userId") String userId, @Param("type") String type);
}
