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

/**
 * @author Li.shangzhi
 * @create 2018/12/29.
 */
public class BooleanUtil {
    /**
     * boolean是
     */
    public static final String BOOLEAN_TRUE = "1";
    /**
     * boolean否
     */
    public static final String BOOLEAN_FALSE = "0";

    public static String switchValue(Boolean value){
        if(value==null) {
            return BOOLEAN_FALSE;
        }
        return value? BOOLEAN_TRUE: BOOLEAN_FALSE;
    }
}
