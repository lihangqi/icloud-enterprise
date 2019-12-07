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
package com.gitee.icloud.iot.common.msg;
/**
 * @FileName ObjectRestResponse.java
 * @Description: RestResponse 返回结果集
 *
 * @Date Dec 25, 2018 3:17:06 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    @SuppressWarnings("rawtypes")
	public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @SuppressWarnings("rawtypes")
	public static ObjectRestResponse ok(Object data) {
        return new ObjectRestResponse<Object>().data(data);
    }

    @SuppressWarnings("rawtypes")
	public static ObjectRestResponse ok() {
        return new ObjectRestResponse<Object>();
    }
}
