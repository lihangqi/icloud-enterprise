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
 * Nov 14, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.gate.config;
import com.gitee.icloud.iot.common.xss.XssFilter;
import com.gitee.icloud.iot.gate.route.RedisRouteLocator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * @Description:
 *
 * @Date Nov 14, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
@Configuration
public class GateConfig {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    ZuulProperties zuulProperties;

    @Autowired
    ServerProperties server;

    /**
     * xssFilter注册
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        XssFilter xssFilter = new XssFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(xssFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(Integer.MIN_VALUE);
        return registration;
    }

    @Bean
    RedisRouteLocator redisRouteLocator() {
        RedisRouteLocator redisRouteLocator = new RedisRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
        redisRouteLocator.setRedisTemplate(this.redisTemplate);
        return redisRouteLocator;
    }


}
