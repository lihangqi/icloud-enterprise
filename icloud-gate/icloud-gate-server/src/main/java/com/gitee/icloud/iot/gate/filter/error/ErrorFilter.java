/*
 * COPYRIGHT Li.shangzhi.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of Li.shangzhi
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Dec 29, 2018    Li.shangzhi         Create the class
 * 
 * https://gitee.com/icloud-iot/
*/
package com.gitee.icloud.iot.gate.filter.error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gitee.icloud.core.constants.CommonConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/**
 * @FileName ErrorFilter.java
 * @Description: zuul过滤器链发生异常统一处理
 *
 * @Date Dec 29, 2018 3:24:54 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class ErrorFilter extends ZuulFilter{
	
	private static final int FILTER_ORDER = 0;
	
	private final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		logger.error("系统异常，执行的过滤器链为：{}", ctx.getFilterExecutionSummary());
		ZuulException zuulException = (ZuulException) ctx.getThrowable();
		logger.error("系统异常，发送异常的过滤器为：{}", zuulException.errorCause, zuulException.getCause());
		ctx.setResponseStatusCode(500);// 异常

		//TODO 统一系统异常返回
		//ctx.setResponseBody();
		return null;
	}

	@Override
	public String filterType() {
		return CommonConstants.ERROR_FILTER;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

}
