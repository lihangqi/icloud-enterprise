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
 * Nov 14, 2018    Li.shangzhi         Create the class
*/
package com.gitee.icloud.gate.ratelimit.config.repository.springdata;
import com.gitee.icloud.gate.ratelimit.config.Rate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * @Description: 
 *
 * @Date Nov 14, 2018 
 * @author Li.shangzhi
 * @version 1.0
 */
@Repository
public interface IRateLimiterRepository extends CrudRepository<Rate, String> {

}
