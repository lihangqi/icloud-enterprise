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
package com.gitee.icloud.iot.dict;
import com.gitee.icloud.iot.auth.client.EnableiCloudAuthClient;
import com.spring4all.swagger.EnableSwagger2Doc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @FileName DictBootstrap.java
 * @Description: 
 *
 * @Date Nov 12, 2018 9:12:23 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
// 开启事务
@EnableTransactionManagement
// 开启熔断监控
@EnableCircuitBreaker
// 开启服务鉴权
@EnableFeignClients({"com.gitee.icloud.iot.auth.client.feign"})
@MapperScan("com.gitee.icloud.iot.dict.mapper")
@EnableiCloudAuthClient
@EnableSwagger2Doc
public class DictBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DictBootstrap.class).web(true).run(args);    }
}
