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
 * Nov 28, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.iot.upms.mapper;
import com.gitee.icloud.iot.common.data.Tenant;
import com.gitee.icloud.iot.common.mapper.CommonMapper;
import com.gitee.icloud.iot.upms.entity.GateLog;
/**
 * @FileName GateLogMapper.java
 * @Description: 
 *
 * @Date Nov 28, 2018 7:20:42 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Tenant(userField = "crt_user")
public interface GateLogMapper extends CommonMapper<GateLog> {
}
