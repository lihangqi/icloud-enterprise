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
package com.gitee.icloud.iot.auth.jwt.user;

import com.gitee.icloud.core.util.jwt.IJWTInfo;
import com.gitee.icloud.core.util.jwt.JWTHelper;
import com.gitee.icloud.iot.auth.configuration.KeyConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author Li.shangzhi
 * @version 2018/9/10
 */
@Component
public class JwtTokenUtil {

    public int getExpire() {
        return expire;
    }

    @Value("${jwt.expire:3600}")

    private int expire;

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private JWTHelper jwtHelper;

    public String generateToken(IJWTInfo jwtInfo, Map<String, String> otherInfo,Date expireTime) throws Exception {
        return jwtHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(), expireTime, otherInfo);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        IJWTInfo infoFromToken = jwtHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
        return infoFromToken;
    }



}
