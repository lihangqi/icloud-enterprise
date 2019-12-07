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
package com.gitee.icloud.iot.dict.config;
import com.gitee.icloud.iot.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.gitee.icloud.iot.auth.client.interceptor.UserAuthRestInterceptor;
import com.gitee.icloud.iot.common.handler.GlobalExceptionHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @FileName DictValueBiz.java
 * @Description: 拦截器和全局配置
 *
 * @Date Nov 12, 2018 9:12:23 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Configuration("securityWebConfig")
@Primary
public class WebConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	GlobalExceptionHandler getGlobalExceptionHandler() {
		return new GlobalExceptionHandler();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
            增加服务权限拦截器
		 */
		registry.addInterceptor(getServiceAuthRestInterceptor()).addPathPatterns("/**");
		/*
            增加用户权限拦截器
		 */
		registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	/**
	 * 配置服务权限拦截
	 * @return
	 */
	@Bean
	ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
		return new ServiceAuthRestInterceptor();
	}

	/**
	 * 配置用户用户token拦截
	 * @return
	 */
	@Bean
	UserAuthRestInterceptor getUserAuthRestInterceptor() {
		return new UserAuthRestInterceptor();
	}

}
