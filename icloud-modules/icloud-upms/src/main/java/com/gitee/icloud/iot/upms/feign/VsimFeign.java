package com.gitee.icloud.iot.upms.feign;
import com.gitee.icloud.iot.auth.client.config.FeignApplyConfiguration;
import com.gitee.icloud.iot.common.msg.ObjectRestResponse;
import com.gitee.icloud.iot.common.msg.TableResultResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
/**
 * @FileName VsimFeign.java
 * @Description:
 *
 * @Date Jan 11, 2019 5:00:58 PM
 * @author wangxiaoqing
 * @version 1.0
 */
@FeignClient(value = "icloud-vsim" ,configuration = FeignApplyConfiguration.class)
public interface VsimFeign {

	@RequestMapping(value = "/baseItem/addBaseItem", method = RequestMethod.POST)
	ObjectRestResponse addBaseItem(
			@RequestParam("baseItemName") String baseItemName,
			@RequestParam("baseItemType") Integer baseItemType,
			@RequestParam("baseItemCapacity") Long baseItemCapacity,
			@RequestParam("productId") Long productId,
			@RequestParam(value = "speedPolicyId") Long speedPolicyId,
			@RequestParam(value = "baseItemDesc", required = false) String  baseItemDesc
			);

	@RequestMapping(value = "/baseItem/addTenantItem", method = RequestMethod.POST)
	ObjectRestResponse addTenantItem(
			@RequestParam("tenantId") String tenantId,
			@RequestParam("baseItemId") Long baseItemId,
			@RequestParam("baseItemPrice") BigDecimal baseItemPrice
			);

	@RequestMapping(value = "/deviceType/addDeviceType", method = RequestMethod.POST)
	ObjectRestResponse addDeviceType(
			@RequestParam("deviceTypeName") String deviceTypeName,
			@RequestParam("productFlows") String productFlows
			);

	@RequestMapping(value = "/deviceType/addTenantDeviceType", method = RequestMethod.POST)
	ObjectRestResponse addTenantDeviceType(
			@RequestParam("tenantId") String tenantId,
			@RequestParam("deviceType") Long deviceType
			);

	@RequestMapping(value = "/deviceType/queryDeviceTypeByPage", method = RequestMethod.GET)
	TableResultResponse queryDeviceTypeByPage(
			@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam(value = "deviceTypeName", required = false) String deviceTypeName
			);

	@RequestMapping(value = "/deviceType/queryTenantDeviceTypeByPage", method = RequestMethod.GET)
	TableResultResponse queryTenantDeviceTypeByPage(
			@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam(value = "tenantId", required = false) String tenantId
			);

	@RequestMapping(value = "/deviceType/modifyDeviceType", method = RequestMethod.PUT)
	ObjectRestResponse modifyDeviceType(
			@RequestParam("id") Long id, 
			@RequestParam(value = "productFlows", required = false) String productFlows);

	@RequestMapping(value = "/baseItem/queryTenantItemByPage", method = RequestMethod.GET)
	TableResultResponse queryTenantItemByPage(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "tenantId", required = false) String tenantId,
			@RequestParam(value = "baseItemId", required = false) Long baseItemId,
			@RequestParam(value = "baseItemName", required = false) String baseItemName,
			@RequestParam(value = "baseItemType", required = false) Integer baseItemType,
			@RequestParam(value = "deviceType", required = false) Long deviceType);


	@RequestMapping(value = "/baseItem/modifyBaseItem", method = RequestMethod.PUT)
	ObjectRestResponse modifyBaseItem(
			@RequestParam("id") Long id,
			@RequestParam("baseItemName") String baseItemName,
			@RequestParam(value = "speedPolicyId") Long speedPolicyId
			);

	@RequestMapping(value = "/baseItem/modifyItemPrice", method = RequestMethod.PUT)
	ObjectRestResponse modifyItemPrice(
			@RequestParam("id") String id,
			@RequestParam(value = "baseItemPrice") BigDecimal baseItemPrice
			);

	@RequestMapping(value = "/baseItem/modifyBaseItemStatus", method = RequestMethod.PUT)
	ObjectRestResponse modifyBaseItemStatus(
			@RequestParam("id") Long id
			);

	@RequestMapping(value = "/baseItem/modifyTenantItemStatus", method = RequestMethod.PUT)
	ObjectRestResponse modifyTenantItemStatus(
			@RequestParam("id") String id
			);

	@RequestMapping(value = "/deviceType/modifyDeviceTypeStatus", method = RequestMethod.PUT)
	ObjectRestResponse modifyDeviceTypeStatus(
			@RequestParam("id") Long id
			);

	@RequestMapping(value = "/deviceType/modifyTenantDeviceTypeStatus", method = RequestMethod.PUT)
	ObjectRestResponse modifyTenantDeviceTypeStatus(
			@RequestParam("id") String id
			);

	@RequestMapping(value = "/baseItem/queryBaseItemByPage", method = RequestMethod.GET)
	TableResultResponse queryBaseItemByPage(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "baseItemName", required = false) String baseItemName,
			@RequestParam(value = "baseItemType", required = false) Integer baseItemType,
			@RequestParam(value = "deviceType", required = false) Long deviceType
			);
}
