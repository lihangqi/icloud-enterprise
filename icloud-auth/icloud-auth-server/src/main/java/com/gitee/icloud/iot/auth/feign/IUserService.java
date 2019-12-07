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
package com.gitee.icloud.iot.auth.feign;
import com.gitee.icloud.iot.auth.configuration.FeignConfiguration;
import com.gitee.icloud.iot.common.msg.ObjectRestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
/**
 * ${DESCRIPTION}
 *
 * @author Li.shangzhi
 * @version 2017-06-21 8:11
 */
@FeignClient(value = "${jwt.user-service:userService}",configuration = FeignConfiguration.class)
public interface IUserService {
	/**
	 * 通过账户\密码的方式登陆
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/user/validate", method = RequestMethod.POST)
	public ObjectRestResponse<Map<String,String>> validate(@RequestParam("username") String username, @RequestParam("password") String password);
	@RequestMapping(value = "/user/info", method = RequestMethod.POST)
	public ObjectRestResponse<Map<String,String>> getUserInfoByUsername(@RequestParam("username") String username);
}
