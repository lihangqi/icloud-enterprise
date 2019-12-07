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
package com.gitee.icloud.iot.auth.module.client.service.impl;
import com.gitee.icloud.core.constants.CommonConstants;
import com.gitee.icloud.core.util.jwt.IJWTInfo;
import com.gitee.icloud.core.util.jwt.JWTInfo;
import com.gitee.icloud.iot.auth.feign.IUserService;
import com.gitee.icloud.iot.auth.jwt.user.JwtTokenUtil;
import com.gitee.icloud.iot.auth.module.client.service.AuthService;
import com.gitee.icloud.iot.common.exception.auth.UserInvalidException;
import com.gitee.icloud.iot.common.util.RedisKeyUtil;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Li.shangzhi
 */
@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(String username, String password) throws Exception {
        Map<String, String> data = userService.validate(username, password).getData();
        String token = "";
        if (!StringUtils.isEmpty(data.get("id"))) {
            Map<String, String> map = new HashMap<>();
            map.put(CommonConstants.JWT_KEY_TENANT_ID, String.valueOf(data.get("tenantId")));
            map.put(CommonConstants.JWT_KEY_DEPART_ID, String.valueOf(data.get("departId")));
            JWTInfo jwtInfo = new JWTInfo(data.get("username"), data.get("id"), data.get("name"));
            Date expireTime = DateTime.now().plusSeconds(jwtTokenUtil.getExpire()).toDate();
            token = jwtTokenUtil.generateToken(jwtInfo, map, expireTime);
            redisTemplate.opsForValue().set(RedisKeyUtil.buildUserAbleKey(data.get("id"), expireTime), "1");
            return token;
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public Boolean invalid(String token) throws Exception {
        IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
        redisTemplate.delete(RedisKeyUtil.buildUserAbleKey(infoFromToken.getId(), infoFromToken.getExpireTime()));
        redisTemplate.opsForValue().set(RedisKeyUtil.buildUserDisableKey(infoFromToken.getId(), infoFromToken.getExpireTime()), "1");
        return true;
    }

    @Override
    public String refresh(String oldToken) throws Exception {
        IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(oldToken);
        invalid(oldToken);
        Date expireTime = DateTime.now().plusSeconds(jwtTokenUtil.getExpire()).toDate();
        redisTemplate.opsForValue().set(RedisKeyUtil.buildUserAbleKey(infoFromToken.getId(), expireTime), "1");
        return jwtTokenUtil.generateToken(infoFromToken, infoFromToken.getOtherInfo(), expireTime);
    }
}
