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
package com.gitee.icloud.iot.auth.client.interceptor;
import com.gitee.icloud.core.context.BaseContextHandler;
import com.gitee.icloud.iot.auth.client.config.ServiceAuthConfig;
import com.gitee.icloud.iot.auth.client.config.UserAuthConfig;
import com.gitee.icloud.iot.auth.client.jwt.ServiceAuthUtil;
import com.gitee.icloud.iot.common.constant.RestCodeConstants;

import lombok.extern.java.Log;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author icloud.iot
 */
@Component
@Log
public class OkHttpTokenInterceptor implements Interceptor {
	@Autowired
	@Lazy
	private ServiceAuthUtil serviceAuthUtil;
	
	@Autowired
	@Lazy
	private ServiceAuthConfig serviceAuthConfig;
	@Autowired
	@Lazy
	private UserAuthConfig userAuthConfig;


	@Override
	public Response intercept(Chain chain) throws IOException {
		Request newRequest = chain.request()
				.newBuilder()
				.header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken())
				.build();
		Response response = chain.proceed(newRequest);
		if(HttpStatus.FORBIDDEN.value()==response.code()){
			if(response.body().string().contains(String.valueOf(RestCodeConstants.EX_CLIENT_INVALID_CODE))){
				log.info("Client Token Expire,Retry to request...");
				serviceAuthUtil.refreshClientToken();
				newRequest = chain.request()
						.newBuilder()
						.header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken())
						.header(serviceAuthConfig.getTokenHeader(),serviceAuthUtil.getClientToken())
						.build();
				response = chain.proceed(newRequest);
			}
		}
	    return response;
	}

}
