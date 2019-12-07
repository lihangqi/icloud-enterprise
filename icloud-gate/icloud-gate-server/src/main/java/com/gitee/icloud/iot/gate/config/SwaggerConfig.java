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
package com.gitee.icloud.iot.gate.config;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description:
 *
 * @Date Nov 14, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
@Component
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("管理服务"   , "/api/upms/v2/api-docs", "2.0"));
        resources.add(swaggerResource("字典服务"   , "/api/dict/v2/api-docs", "2.0"));
        resources.add(swaggerResource("鉴权服务"   , "/api/auth/v2/api-docs", "2.0"));
        resources.add(swaggerResource("vSim服务"  , "/api/vsim/v2/api-docs", "2.0"));
        resources.add(swaggerResource("开放API服务", "/api/open/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
