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
package com.gitee.icloud.iot.gate.feign;
import com.gitee.icloud.iot.api.vo.authority.PermissionInfo;
import com.gitee.icloud.iot.gate.config.FeignConfiguration;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
/**
 * @Description:
 *
 * @Date Nov 14, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
@FeignClient(value = "icloud-upms",configuration = FeignConfiguration.class)
public interface IUserFeign {
	/**
	 * 获取用户的菜单和按钮权限
	 * @return
	 */
	@RequestMapping(value="/api/user/permissions",method = RequestMethod.GET)
	public List<PermissionInfo> getPermissionByUsername();

	/**
	 * 获取所有菜单和按钮权限
	 * @return
	 */
	@RequestMapping(value="/api/permissions",method = RequestMethod.GET)
	List<PermissionInfo> getAllPermissionInfo();
}
