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
package com.gitee.icloud.iot.gate;
import com.gitee.icloud.gate.ratelimit.EnableiCloudGateRateLimit;
import com.gitee.icloud.gate.ratelimit.config.IUserPrincipal;
import com.gitee.icloud.iot.auth.client.EnableiCloudAuthClient;
import com.gitee.icloud.iot.gate.config.UserPrincipal;
import com.gitee.icloud.iot.gate.utils.DBLog;
import com.spring4all.swagger.EnableSwagger2Doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @FileName GateBootstrap.java
 * @Description: 网关服务
 *
 * @Date Nov 14, 2018 2:17:32 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.gitee.icloud.iot.auth.client.feign","com.gitee.icloud.iot.gate.feign"})
@EnableZuulProxy
@EnableScheduling
@EnableiCloudAuthClient
//限流管理
@EnableiCloudGateRateLimit
@EnableSwagger2Doc
public class GateBootstrap {
    public static void main(String[] args) {
        DBLog.getInstance().start(); 
        SpringApplication.run(GateBootstrap.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
