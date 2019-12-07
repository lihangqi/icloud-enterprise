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
 * Nov 13, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.merge.annonation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Description: 
 *
 * @Date Nov 13, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
public @interface MergeField {
    /**
     * 查询值
     * @return
     */
    String key() default "";

    /**
     * 目标类
     * @return
     */
    Class<? extends Object> feign() default Object.class;

    /**
     * 调用方法
     * @return
     */
    String method() default "";

    /**
     * 是否以属性值合并作为查询值
     * @return
     */
    boolean isValueNeedMerge() default false;
}
