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
 * Nov 13, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.merge.facade;

import java.util.List;
/**
 * @Description: 
 *
 * @Date Nov 13, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
public interface IMergeResultParser {
    /**
     * 提取防范返回值中需要合并的有效列表
     * @param methodResult
     * @return
     */
    public List parser(Object methodResult);
}
