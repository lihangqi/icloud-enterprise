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
 * Nov 12, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.common.util;

import com.gitee.icloud.core.constants.CommonConstants;
import com.gitee.icloud.iot.common.constant.RedisKeyConstants;

import java.util.Date;

/**
 * @author Li.shangzhi
 * @create 2018/3/11.
 */
public class RedisKeyUtil {
    /**
     *
     * @param userId
     * @param expire
     * @return
     */
    public static String buildUserAbleKey(String userId,Date expire){
        return CommonConstants.REDIS_USER_TOKEN + RedisKeyConstants.USER_ABLE + userId + ":" + expire.getTime();
    }

    /**
     * 
     * @param userId
     * @param expire
     * @return
     */
    public static String buildUserDisableKey(String userId,Date expire){
        return CommonConstants.REDIS_USER_TOKEN + RedisKeyConstants.USER_DISABLE + userId + ":" + expire.getTime();
    }
}
