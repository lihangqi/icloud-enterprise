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
package com.gitee.icloud.iot.common.data;

import java.util.List;
/**
 * @FileName IUserDepartDataService.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:12:12 PM
 * @author Li.shangzhi
 * @version 1.0
 */
public interface IUserDepartDataService {
    /**
     * 根据用户获取用户可访问的数据部门Id
     * @param userId
     * @return
     */
    public List<String> getUserDataDepartIds(String userId);
}
