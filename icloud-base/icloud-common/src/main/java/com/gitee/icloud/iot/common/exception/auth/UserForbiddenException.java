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
package com.gitee.icloud.iot.common.exception.auth;
import com.gitee.icloud.core.exception.BaseException;
import com.gitee.icloud.iot.common.constant.RestCodeConstants;
/**
 * @FileName UserForbiddenException.java
 * @Description: 
 *
 * @Date Dec 12, 2018 5:36:48 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class UserForbiddenException extends BaseException {
	private static final long serialVersionUID = 1L;

	public UserForbiddenException(String message) {
        super(message, RestCodeConstants.EX_USER_FORBIDDEN_CODE);
    }

}
