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
package com.gitee.icloud.iot.common.constant;
/**
 * @FileName RestCodeConstants.java
 * @Description: rest接口返回码
 *
 * @Date Jan 16, 2019 6:46:48 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class RestCodeConstants {
	
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE 	  = 40101;
    public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
    public static final Integer EX_USER_FORBIDDEN_CODE    = 40131;
    
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE    = 40301;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE  = 40331;
    
    // 业务异常返回码
    public static final Integer EX_BUSINESS_BASE_CODE     = 30101;


}
