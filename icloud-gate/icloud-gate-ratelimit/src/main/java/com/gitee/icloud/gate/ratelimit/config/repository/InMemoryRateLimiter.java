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
package com.gitee.icloud.gate.ratelimit.config.repository;

import com.gitee.icloud.gate.ratelimit.config.Rate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @Description: 
 *
 * @Date Nov 14, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
public class InMemoryRateLimiter extends AbstractRateLimiter {

    private Map<String, Rate> repository = new ConcurrentHashMap<>();

    @Override
    protected Rate getRate(String key) {
        return this.repository.get(key);
    }

    @Override
    protected void saveRate(Rate rate) {
        this.repository.put(rate.getKey(), rate);
    }

}
