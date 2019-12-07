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
package com.gitee.icloud.core.constants;
/**
 * @FileName CommonConstants.java
 * @Description: 甯搁噺淇℃伅绫�
 *
 * @Date Nov 12, 2018 2:08:27 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class CommonConstants {
	public static final String CONTEXT_KEY_USER_ID = "currentUserId";
	public static final String CONTEXT_KEY_USERNAME = "currentUserName";
	public static final String CONTEXT_KEY_USER_NAME = "currentUser";
	public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
	public static final String CONTEXT_KEY_TENANT_ID = "currentTenantId";
	public static final String CONTEXT_KEY_DEPART_ID = "currentDepartId";
	public static final String JWT_KEY_USER_ID = "userId";
	public static final String JWT_KEY_NAME = "userName";
	public static final String JWT_KEY_EXPIRE = "expire";
	public static final String JWT_KEY_TENANT_ID = "tenant";
	public static final String JWT_KEY_DEPART_ID = "depart";
	public static final String REDIS_USER_TOKEN = "jwt:user_";
	
	
	/*
	 * zuul杩囨护鍣ㄥ父閲� 
	 * pre锛氬彲浠ュ湪璇锋眰琚矾鐢变箣鍓嶈皟鐢� 
	 * route锛氬湪璺敱璇锋眰鏃跺�欒璋冪敤 
	 * post锛氬湪routing鍜宔rror杩囨护鍣ㄤ箣鍚庤璋冪敤
	 * error锛氬鐞嗚姹傛椂鍙戠敓閿欒鏃惰璋冪敤
	 */
	public static final String PRE_FILTER = "pre";
	public static final String ROUTE_FILTER = "route";
	public static final String ERROR_FILTER = "error";
	public static final String POST_FILTER = "post";

}
