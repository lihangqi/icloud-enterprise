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
 * Nov 28, 2018    Li.shangzhi         Create the class
 */
package com.gitee.icloud.iot.upms.rest;
import com.gitee.icloud.iot.auth.client.annotation.CheckClientToken;
import com.gitee.icloud.iot.auth.client.annotation.CheckUserToken;
import com.gitee.icloud.iot.common.msg.ObjectRestResponse;
import com.gitee.icloud.iot.common.msg.TableResultResponse;
import com.gitee.icloud.iot.common.rest.BaseController;
import com.gitee.icloud.iot.upms.biz.ElementBiz;
import com.gitee.icloud.iot.upms.biz.UserBiz;
import com.gitee.icloud.iot.upms.entity.Element;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @FileName ElementController.java
 * @Description: 
 *
 * @Date Dec 21, 2018 1:52:51 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Controller
@CheckUserToken
@CheckClientToken
@RequestMapping("element")
@Api(tags = "资源管理")
public class ElementController extends BaseController<ElementBiz, Element,String> {
	@Autowired
	private UserBiz userBiz;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation("根据菜单获取资源")
	public TableResultResponse<Element> page(@RequestParam(defaultValue = "10") int limit,
			@RequestParam(defaultValue = "1") int offset,String name, @RequestParam(defaultValue = "0") String menuId) {
		Example example = new Example(Element.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("menuId", menuId);
		if(StringUtils.isNotBlank(name)){
			criteria.andLike("name", "%" + name + "%");
		}
		List<Element> elements = baseBiz.selectByExample(example);
		return new TableResultResponse<Element>(elements.size(), elements);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	@Deprecated
	public ObjectRestResponse<Element> getAuthorityElement(String menuId) {
		String userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
		List<Element> elements = baseBiz.getAuthorityElementByUserId(userId + "",menuId);
		return new ObjectRestResponse<List<Element>>().data(elements);
	}

	@RequestMapping(value = "/user/menu", method = RequestMethod.GET)
	@ResponseBody
	@Deprecated
	public ObjectRestResponse<Element> getAuthorityElement() {
		String userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
		List<Element> elements = baseBiz.getAuthorityElementByUserId(userId + "");
		return new ObjectRestResponse<List<Element>>().data(elements);
	}
}
