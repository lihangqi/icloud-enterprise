# icloud-enterprise （iCloud-IOT 企业版）

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

![输入图片说明](https://images.gitee.com/uploads/images/2019/0905/173321_41c3dba6_1468963.png "屏幕截图.png")

#### 项目启动
###### 依次启动
- CenterBootstrap（icloud-center）  	       注册中心
- ConfigServerBootstrap（icloud-config）配置中心
- AuthBootstrap（icloud-auth-server）         鉴权中心
- DictBootstrap（icloud-dict）    		        字典服务
- UpmsBootstrap（icloud-upms）                              业务服务
- GateBootstrap（icloud-gate）                              网关服务

#### 项目结构
	icloud-iot （icloud-enterprise）
	| 
	|———icloud-center:8761    ------------ 服务注册中心
	|
	|———icloud-config:8750    ------------ 统一配置中心
	|
	|———icloud-module    	  ------------ 业务服务模块
	|	├── icloud-upms:8762 ------------ UPMS 基础服务支撑系统       
	|	├── icloud-dict:9999  ------------ 基础数据字典服务
	|	├── icloud-interface  ------------ 基础服务数据对象
	|
	├── icloud-gate           ------------ 网关模块
	|	├── icloud-gate-ratelimit--------- 网关流控SDK
	|	├── icloud-gate-server  ---------- 网关服务
	|
	├── icloud-auth           ------------ 鉴权模块
	|	├── icloud-auth-client  ---------- 鉴权客户端 SDK
	|	├── icloud-auth-server:9777 ------ 鉴权中心服务
	|
	|── icloud-base            ----------- 基础工具模块
	|	├── icloud-common      ------------公用COMM
	|	├── icloud-core        ------------核心模块
	|	├── icloud-merge-core  ------------数据聚合工具
	|
	|── icloud-control         ----------- 统一监控中心
	|	├── icloud-monitor:8764------------服务监控中心
	|	├── icloud-trace:9411  ------------链路路追踪中心
	|
	|── icloud-postman-api     ----------- Postman 调试API接口管理

> 项目启动顺序
- 1.服务注册中心  (icloud-center)
- 2.鉴权中心服务 (icloud-auth-server)
- 3.基础数据字典服务 (icloud-dict)
- 4.UPMS 基础服务支撑系统  (icloud-upms)
- 5.网关服务 (icloud-gate-server)

> 鉴于中小型创业公司对于服务内部鉴权的认知度不高,可将Client Token 去除
![输入图片说明](https://images.gitee.com/uploads/images/2019/0905/171937_53647edd_1468963.png "屏幕截图.png" )

### 服务架构说明
![输入图片说明](https://images.gitee.com/uploads/images/2019/0905/172818_f161ad21_1468963.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0905/172936_30185852_1468963.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0905/171814_629900c2_1468963.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0905/171841_4c2522a5_1468963.png "屏幕截图.png")








 