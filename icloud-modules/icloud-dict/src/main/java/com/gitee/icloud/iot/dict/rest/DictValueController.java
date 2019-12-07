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
package com.gitee.icloud.iot.dict.rest;
import com.gitee.icloud.iot.auth.client.annotation.CheckClientToken;
import com.gitee.icloud.iot.auth.client.annotation.CheckUserToken;
import com.gitee.icloud.iot.auth.client.annotation.IgnoreClientToken;
import com.gitee.icloud.iot.auth.client.annotation.IgnoreUserToken;
import com.gitee.icloud.iot.common.msg.TableResultResponse;
import com.gitee.icloud.iot.common.rest.BaseController;
import com.gitee.icloud.iot.dict.biz.DictValueBiz;
import com.gitee.icloud.iot.dict.entity.DictValue;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.mapper.entity.Example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @FileName
 * @Description: 
 *
 * @Date Nov 12, 2018 9:12:23 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@RestController
@RequestMapping("dictValue")
@CheckClientToken
@CheckUserToken
@Api(tags = "字典值服务",description = "字典值服务")
public class DictValueController extends BaseController<DictValueBiz,DictValue,String> {
    @IgnoreClientToken
    @IgnoreUserToken
    @RequestMapping(value = "/type/{code}",method = RequestMethod.GET)
    public TableResultResponse<DictValue> getDictValueByDictTypeCode(@PathVariable("code") String code){
        Example example = new Example(DictValue.class);
        example.createCriteria().andLike("code",code+"%");
        List<DictValue> dictValues = this.baseBiz.selectByExample(example).stream().sorted(new Comparator<DictValue>() {
            @Override
            public int compare(DictValue o1, DictValue o2) {
                return o1.getOrderNum() - o2.getOrderNum();
            }
        }).collect(Collectors.toList());
        return new TableResultResponse<DictValue>(dictValues.size(),dictValues);
    }

    @IgnoreClientToken
    @IgnoreUserToken
    @RequestMapping(value = "/feign/{code}",method = RequestMethod.GET)
    public Map<String,String> getDictValueByCode(@PathVariable("code") String code){
        Example example = new Example(DictValue.class);
        example.createCriteria().andLike("code",code+"%");
        List<DictValue> dictValues = this.baseBiz.selectByExample(example);
        Map<String, String> result = dictValues.stream().collect(
                Collectors.toMap(DictValue::getValue, DictValue::getLabelDefault));
        return result;
    }
}