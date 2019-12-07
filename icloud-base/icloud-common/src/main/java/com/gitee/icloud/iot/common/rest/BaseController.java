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
package com.gitee.icloud.iot.common.rest;

import com.gitee.icloud.core.context.BaseContextHandler;
import com.gitee.icloud.iot.common.biz.BaseBiz;
import com.gitee.icloud.iot.common.msg.ObjectRestResponse;
import com.gitee.icloud.iot.common.msg.TableResultResponse;
import com.gitee.icloud.iot.common.util.Query;
import com.gitee.icloud.iot.common.util.StringEscapeEditor;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;
/**
 * @FileName BaseController.java
 * @Description: 
 *
 * @Date Dec 7, 2018 3:06:51 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class BaseController<Biz extends BaseBiz,Entity,PK> {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
        binder.registerCustomEditor(String[].class, new StringEscapeEditor());
    }

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;
    
    /**
     * @Title: add 
     * @Description:新增单个对象
     * @param entity
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:34:54 AM
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增单个对象")
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }

    /**
     * @Title: get 
     * @Description:查询单个对象
     * @param id
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:35:10 AM
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询单个对象")
    public ObjectRestResponse<Entity> get(@PathVariable PK id){
        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
        Object o = baseBiz.selectById(id);
        entityObjectRestResponse.data((Entity)o);
        return entityObjectRestResponse;
    }

    /**
     * @Title: update 
     * @Description:更新单个对象
     * @param entity
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:35:19 AM
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("更新单个对象")
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }
    
    /**
     * @Title: remove 
     * @Description:移除单个对象
     * @param id
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:35:44 AM
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("移除单个对象")
    public ObjectRestResponse<Entity> remove(@PathVariable PK id){
        baseBiz.deleteById(id);
        return new ObjectRestResponse<Entity>();
    }

    /**
     * @Title: all 
     * @Description:获取所有数据
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:36:00 AM
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取所有数据")
    public List<Entity> all(){
        return baseBiz.selectListAll();
    }
    
    /***
     * @Title: list 
     * @Description:分页获取数据
     * @param params
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:36:22 AM
     */
    @ApiOperation("分页获取数据")
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return baseBiz.selectByQuery(query);
    }
    
    /**
     * @Title: getCurrentUserName 
     * @Description:获取当前用户昵称
     * @return 
     * @author Li.shangzhi
     * @date Mar 4, 2019 10:36:42 AM
     */
    public String getCurrentUserName(){
        return BaseContextHandler.getUsername();
    }
}
