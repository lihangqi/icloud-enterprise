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
 * Nov 13, 2018    Li.shangzhi         Create the class
 */
package com.gitee.icloud.iot.upms;
import com.gitee.icloud.iot.auth.client.EnableiCloudAuthClient;
import com.gitee.icloud.merge.EnableiCloudMerge;
import com.icloud.cache.EnableiCloudCache;
import com.spring4all.swagger.EnableSwagger2Doc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @FileName AdminBootstrap.java
 * @Description: 
 *
 * @Date Nov 13, 2018 4:35:40 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.gitee.icloud.iot.auth.client.feign","com.gitee.icloud.iot.upms.feign"})
@EnableScheduling
@EnableiCloudCache
@EnableTransactionManagement
@MapperScan("com.gitee.icloud.iot.upms.mapper")
@EnableiCloudAuthClient
@EnableSwagger2Doc
@EnableiCloudMerge
public class UpmsBootstrap {
	public static void main(String[] args) {
		new SpringApplicationBuilder(UpmsBootstrap.class).web(true).run(args);    }
}
