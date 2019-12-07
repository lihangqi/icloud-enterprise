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
 * Nov 19, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.upms.rpc;
import com.gitee.icloud.iot.api.vo.log.LogInfo;
import com.gitee.icloud.iot.upms.biz.GateLogBiz;
import com.gitee.icloud.iot.upms.entity.GateLog;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 
 * @FileName LogRest.java
 * @Description: 日志管理
 *
 * @Date Nov 19, 2018 11:44:14 AM
 * @author Li.shangzhi
 * @version 1.0
 */
@RequestMapping("api")
@RestController
public class LogRest {
    @Autowired
    private GateLogBiz gateLogBiz;
    @RequestMapping(value="/log/save",method = RequestMethod.POST)
    public @ResponseBody void saveLog(@RequestBody LogInfo info){
        GateLog log = new GateLog();
        BeanUtils.copyProperties(info,log);
        gateLogBiz.insertSelective(log);
    }
}
