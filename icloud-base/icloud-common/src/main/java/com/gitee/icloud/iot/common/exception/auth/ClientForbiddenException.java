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
 * @FileName ClientForbiddenException.java
 * @Description: 
 *
 * @Date Dec 12, 2018 5:35:17 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class ClientForbiddenException extends BaseException {
	private static final long serialVersionUID = 1L;

	public ClientForbiddenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_FORBIDDEN_CODE);
    }
}
