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
package com.gitee.icloud.iot.common.util;

import com.gitee.icloud.core.context.BaseContextHandler;
import com.gitee.icloud.iot.common.audit.*;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
/**
 * @FileName EntityUtils.java
 * @Description:
 * 				 * 实体类相关工具类
 * 				       解决问题： 1、快速对实体的常驻字段，如：crtUser、crtHost、updUser等值快速注入
 *
 * @Date Dec 21, 2018 1:56:34 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Slf4j
public class EntityUtils {

    /**
     * 快速将bean的crtUserName, crtUserId, crtTime、updUserName, updUserId, updTime附上相关值
     *
     * @param entity 实体bean
     * @author 李尚志
     */
    public static <T> void setCreatAndUpdatInfo(T entity) {
        setCreateInfo(entity);
        setUpdatedInfo(entity);
    }

    /**
     * 快速将bean的crtUserName, crtUserId, crtTime附上相关值
     *
     * @param entity 实体bean
     * @author 李尚志
     */
    public static <T> void setCreateInfo(T entity) {
        String userName = BaseContextHandler.getName();
        String userId = BaseContextHandler.getUserID();
        String departId = BaseContextHandler.getDepartID();
        //不能很好的选择租户ID，在业务手动加上租户ID，不再进行自动注入
//        String tenantId = BaseContextHandler.getTenantID();

        // 默认属性
        String[] fieldNames = {"crtUserName", "crtUserId", "crtTime","departId"};
        if (entity.getClass().getAnnotation(iCloudAudit.class) != null) {
            Field[] fields = entity.getClass().getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    if (field.getAnnotation(CrtUserName.class) != null) {
                        fieldNames[0] = field.getName();
                        continue;
                    }
                    if (field.getAnnotation(CrtUserId.class) != null) {
                        fieldNames[1] = field.getName();
                        continue;
                    }
                    if (field.getAnnotation(CrtTime.class) != null) {
                        fieldNames[2] = field.getName();
                        continue;
                    }
                }
            }
        }
        Field field = ReflectionUtils.getAccessibleField(entity, "crtTime");
        // 默认值
        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{userName, userId, new Date(),departId};
        }
        // 填充默认属性值
        setDefaultValues(entity, fieldNames, value);
    }

    /**
     * 快速将bean的updUserName, updUserId, updTime附上相关值
     *
     * @param entity 实体bean
     * @author 李尚志
     */

    public static <T> void setUpdatedInfo(T entity) {
        String userName = BaseContextHandler.getName();
        String userId = BaseContextHandler.getUserID();
        // 默认属性
        String[] fieldNames = {"updUserName", "updUserId", "updTime"};
        if (entity.getClass().getAnnotation(iCloudAudit.class) != null) {
            Field[] fields = entity.getClass().getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    if (field.getAnnotation(ModifiedUserName.class) != null) {
                        fieldNames[0] = field.getName();
                        continue;
                    }
                    if (field.getAnnotation(ModifiedUserId.class) != null) {
                        fieldNames[1] = field.getName();
                        continue;
                    }
                    if (field.getAnnotation(ModifiedTime.class) != null) {
                        fieldNames[2] = field.getName();
                        continue;
                    }
                }
            }
        }
        Field field = ReflectionUtils.getAccessibleField(entity, "updTime");
        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{userName, userId, new Date()};
        }
        // 填充默认属性值
        setDefaultValues(entity, fieldNames, value);
    }

    /**
     * 依据对象的属性数组和值数组对对象的属性进行赋值
     *
     * @param entity 对象
     * @param fields 属性数组
     * @param value  值数组
     * @author 李尚志
     */
    private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            try {
                if (ReflectionUtils.hasField(entity, field)) {
                    ReflectionUtils.invokeSetter(entity, field, value[i]);
                }
            } catch (Exception e) {
                sb.append(field).append(" ");
            }
        }
        if (!sb.toString().isEmpty()) {
            log.error(entity.getClass().getName() + ",部分字段审计失败: " + sb.toString());
        }
    }

    /**
     * 根据主键属性，判断主键是否值为空
     *
     * @param entity
     * @param field
     * @return 主键为空，则返回false；主键有值，返回true
     * @author 李尚志
     * @version 2016年4月28日
     */
    public static <T> boolean isPKNotNull(T entity, String field) {
        if (!ReflectionUtils.hasField(entity, field)) {
            return false;
        }
        Object value = ReflectionUtils.getFieldValue(entity, field);
        return value != null && !"".equals(value);
    }
}
