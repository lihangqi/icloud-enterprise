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
package com.gitee.icloud.merge.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @Description: 
 *
 * @Date Nov 13, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
@Data
@ConfigurationProperties("merge")
public class MergeProperties {
    /**
     * guava缓存的键值数
     */
    private Integer guavaCacheNumMaxSize;
    /**
     * guava更新混存的下一次时间,分钟
     */
    private Integer guavaCacheRefreshWriteTime;
    /**
     * guava
     */
    private Integer guavaCacheRefreshThreadPoolSize;

    public Integer getGuavaCacheNumMaxSize() {
        return guavaCacheNumMaxSize;
    }

    public void setGuavaCacheNumMaxSize(Integer guavaCacheNumMaxSize) {
        this.guavaCacheNumMaxSize = guavaCacheNumMaxSize;
    }

    public Integer getGuavaCacheRefreshWriteTime() {
        return guavaCacheRefreshWriteTime;
    }

    public void setGuavaCacheRefreshWriteTime(Integer guavaCacheRefreshWriteTime) {
        this.guavaCacheRefreshWriteTime = guavaCacheRefreshWriteTime;
    }

}
