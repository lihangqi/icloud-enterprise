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
package com.gitee.icloud.iot.common.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author Li.shangzhi
 * @version 2018/1/13.
 */
@Data
public class BusinessEntity extends BaseEntity {
    private String crtUserId;
    private String crtUserName;
    private Date crtTime;

    private String updUserId;
    private String updUserName;
    private Date updTime;
}
