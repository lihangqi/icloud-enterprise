package com.gitee.icloud.iot.auth.module.client.mapper;
import com.gitee.icloud.iot.auth.module.client.entity.ClientService;
import com.gitee.icloud.iot.common.mapper.CommonMapper;
/**
 * @FileName ClientServiceMapper.java
 * @Description: 
 *
 * @Date Dec 21, 2018 1:55:08 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public interface ClientServiceMapper extends CommonMapper<ClientService> {
    void deleteByServiceId(String id);
}
