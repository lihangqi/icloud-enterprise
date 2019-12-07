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
import com.gitee.icloud.iot.upms.entity.ResourceAuthority;

import org.apache.ibatis.annotations.Param;
/**
 * @FileName ResourceAuthorityMapper.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:21:23 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public interface ResourceAuthorityMapper extends CommonMapper<ResourceAuthority> {
    public void deleteByAuthorityIdAndResourceType(@Param("authorityId")String authorityId,@Param("resourceType") String resourceType,@Param("type") String type);
}
