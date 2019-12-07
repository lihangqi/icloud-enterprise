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
package com.gitee.icloud.iot.auth.constant;

/**
 * @author Li.shangzhi
 * @create 2018/3/23.
 */
public class RedisKeyConstant {
    public static final String REDIS_USER_PRI_KEY = "ICLOUD:AUTH:JWT:PRI";
    public static final String REDIS_USER_PUB_KEY = "ICLOUD:AUTH:JWT:PUB";
    public static final String REDIS_SERVICE_PRI_KEY = "ICLOUD:AUTH:CLIENT:PRI";
    public static final String REDIS_SERVICE_PUB_KEY = "ICLOUD:AUTH:CLIENT:PUB";
}
