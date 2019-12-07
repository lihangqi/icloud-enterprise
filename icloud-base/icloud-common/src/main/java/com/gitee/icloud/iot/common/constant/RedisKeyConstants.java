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
package com.gitee.icloud.iot.common.constant;
/**
 * @FileName RedisKeyConstants.java
 * @Description: RedisKeyConstants
 *
 * @Date Mar 1, 2019 4:21:35 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class RedisKeyConstants {
    public final static String USER_DEPART_PREFIX = "USER:DEPART";
    public final static String ZUUL_ROUTE_KEY = "ZUUL:ROUTE";
    public final static String USER_DISABLE = ":dis:";
    public final static String USER_ABLE = ":able:";
    public static final String REDIS_USER_PRI_KEY = "ICLOUD:AUTH:JWT:PRI";
    public static final String REDIS_USER_PUB_KEY = "ICLOUD:AUTH:JWT:PUB";
    public static final String REDIS_SERVICE_PRI_KEY = "ICLOUD:AUTH:CLIENT:PRI";
    public static final String REDIS_SERVICE_PUB_KEY = "ICLOUD:AUTH:CLIENT:PUB";
    
    
    public static final String REDIS_VSIM_DEVICETYPE_FLOW_PREFIX = "ICLOUD:VSIM:DEVICETYPE:FLOW:";
    /**
     * CDR检查唯一key
     */
    public static final String REDIS_VSIM_CDR_CHECK_PREFIX = "ICLOUD:VSIM:CDR:CHECK:";
    /**
     * 用户流量统计key
     */
    public static final String REDIS_VSIM_CDR_DATA_PREFIX = "ICLOUD:VSIM:CDR:DATA:";
}
