package com.gitee.icloud.iot.auth.module.client.mapper;
import com.gitee.icloud.iot.auth.module.client.entity.Client;
import com.gitee.icloud.iot.common.mapper.CommonMapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface ClientMapper extends CommonMapper<Client> {
//    @Select(" SELECT\n" +
//            "        client.CODE\n" +
//            "      FROM\n" +
//            "          auth_client client\n" +
//            "      INNER JOIN auth_client_service gcs ON gcs.client_id = client.id\n" +
//            "    WHERE\n" +
//            "        gcs.service_id = #{serviceId}")
//    @ResultType(String.class)
    List<String> selectAllowedClient(String serviceId);

    List<Client> selectAuthorityServiceInfo(String clientId);
}
