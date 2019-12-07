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
import com.gitee.icloud.iot.upms.entity.ResourceAuthority;
import com.gitee.icloud.iot.upms.mapper.ResourceAuthorityMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @FileName ResourceAuthorityBiz.java
 * @Description: 
 *
 * @Date Nov 28, 2018 6:56:58 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BusinessBiz<ResourceAuthorityMapper,ResourceAuthority> {
    public void deleteByAuthorityIdAndResourceType(String s, String resourceTypeMenu, String type) {
        this.mapper.deleteByAuthorityIdAndResourceType(s,resourceTypeMenu,type);
    }
}
