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
package com.gitee.icloud.iot.upms.service;

import com.gitee.icloud.iot.common.msg.TableResultResponse;
import com.gitee.icloud.merge.facade.IMergeResultParser;

import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @FileName TableResultParser.java
 * @Description: 
 *
 * @Date Dec 21, 2018 1:53:33 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Component
public class TableResultParser implements IMergeResultParser {
    @Override
    public List parser(Object o) {
        TableResultResponse response = (TableResultResponse) o;
        TableResultResponse.TableData data = (TableResultResponse.TableData) response.getData();
        List result = data.getRows();
        return result;
    }
}
