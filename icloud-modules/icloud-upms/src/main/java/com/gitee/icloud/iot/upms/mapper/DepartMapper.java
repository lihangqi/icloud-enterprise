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
import com.gitee.icloud.iot.common.data.Tenant;
import com.gitee.icloud.iot.common.mapper.CommonMapper;
import com.gitee.icloud.iot.upms.entity.Depart;
import com.gitee.icloud.iot.upms.entity.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @FileName DepartMapper.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:20:30 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Tenant
public interface DepartMapper extends CommonMapper<Depart> {

    List<User> selectDepartUsers(@Param("departId") String departId,@Param("userName") String userName);

    void deleteDepartUser(@Param("departId")String departId, @Param("userId") String userId);

    void insertDepartUser(@Param("id") String id, @Param("departId") String departId, @Param("userId") String userId,@Param("tenantId") String tenantId);

}
