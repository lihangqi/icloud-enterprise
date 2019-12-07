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
package com.gitee.icloud.core.util.jwt;
import java.util.Date;
import java.util.Map;
/**
 * @FileName IJWTInfo.java
 * @Description: IJWTInfo
 *
 * @Date Nov 12, 2018 2:08:27 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public interface IJWTInfo {
    /**
     * 获取用户名
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户ID
     * @return
     */
    String getId();

    /**
     * 获取名称
     * @return
     */
    String getName();

    /**
     * 获取过期时间
     * @return
     */
    Date getExpireTime();
    /**
     *
     * 获取其他信息
     */
    Map<String,String> getOtherInfo();

}
