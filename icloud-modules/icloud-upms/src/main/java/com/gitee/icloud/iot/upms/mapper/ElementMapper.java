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
import com.gitee.icloud.iot.upms.entity.Element;

import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @FileName ElementMapper.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:20:34 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public interface ElementMapper extends CommonMapper<Element> {
    public List<Element> selectAuthorityElementByUserId(@Param("userId")String userId, @Param("type") String type);
    public List<Element> selectAuthorityMenuElementByUserId(@Param("userId")String userId,@Param("menuId")String menuId, @Param("type") String type);
    public List<Element> selectAuthorityElementByClientId(@Param("clientId")String clientId, @Param("type") String type);
    public List<Element> selectAllElementPermissions();
}
