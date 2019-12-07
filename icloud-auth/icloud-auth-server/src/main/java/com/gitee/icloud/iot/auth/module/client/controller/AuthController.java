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
package com.gitee.icloud.iot.auth.module.client.controller;

import com.gitee.icloud.iot.auth.jwt.user.JwtAuthenticationRequest;
import com.gitee.icloud.iot.auth.module.client.service.AuthService;
import com.gitee.icloud.iot.common.constant.RequestHeaderConstants;
import com.gitee.icloud.iot.common.msg.ObjectRestResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("jwt")
@Deprecated
public class AuthController {
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if (StringUtils.isBlank(token)) {
            return new ObjectRestResponse<String>().data("");
        }
        return new ObjectRestResponse<String>().data(RequestHeaderConstants.JWT_TOKEN_TYPE + token);
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ObjectRestResponse<String> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(getRealToken(token));
        return new ObjectRestResponse<String>().data(RequestHeaderConstants.JWT_TOKEN_TYPE + refreshedToken);
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ObjectRestResponse<?> verify(String token) throws Exception {
        authService.validate(getRealToken(token));
        return new ObjectRestResponse<Boolean>().data(true);
    }

    @RequestMapping(value = "invalid", method = RequestMethod.POST)
    public ObjectRestResponse<Boolean> invalid(@RequestParam("token") String token) throws Exception {
        authService.invalid(getRealToken(token));
        return new ObjectRestResponse<Boolean>().data(true);
    }

    /**
     * 获取真正得JWT Token
     * @param originToken
     * @return
     */
    private String getRealToken(String originToken) {
        if (originToken != null && originToken.startsWith(RequestHeaderConstants.JWT_TOKEN_TYPE)) {
            originToken = originToken.substring(RequestHeaderConstants.JWT_TOKEN_TYPE.length(), originToken.length());
        }
        return originToken;
    }
}
