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
package com.gitee.icloud.iot.common.audit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @FileName ModifiedUserName.java
 * @Description: 
 *
 * @Date Dec 25, 2018 6:01:58 PM
 * @author Li.shangzhi
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
public @interface ModifiedUserName {
}
