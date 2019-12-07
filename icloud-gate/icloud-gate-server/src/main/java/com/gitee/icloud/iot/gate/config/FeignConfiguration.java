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

import com.gitee.icloud.iot.auth.client.interceptor.ServiceFeignInterceptor;

import org.springframework.context.annotation.Bean;
/**
 * @FileName FeignConfiguration.java
 * @Description: 
 *
 * @Date Nov 14, 2018 4:01:31 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class FeignConfiguration {
    @Bean
    ServiceFeignInterceptor getClientTokenInterceptor(){
        return new ServiceFeignInterceptor();
    }
}
