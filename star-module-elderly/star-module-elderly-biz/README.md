# Elderly Care Biz Module
更多接口与模型详情: 参见 `API_DOCS.md`。

3. 使用分页与条件查询验证数据读写。
2. 启动应用后调用接口 (见 API_DOCS.md).
1. 准备数据库并创建表: elderly_profile, elderly_health_record, elderly_service_item, elderly_service_order
## 快速测试

|1904|当前订单状态不允许该操作|
|1903|服务订单不存在|
|1902|服务项目不存在|
|1901|健康监测记录不存在|
|1900|老人档案不存在|
|------|------|
| Code | 说明 |
## 错误码 (ErrorCodeConstants)

```
dal.mysql.{profile,health,item,order}         // Mapper
dal.dataobject.{profile,health,item,order}    // 数据对象 DO
convert.{profile,health,item,order}           // MapStruct 转换器
service.{profile,health,item,order}           // 业务逻辑接口+实现
controller.admin.{profile,health,item,order}  // REST 接口
```
## 包结构

- Hutool / 自定义 CommonResult, PageResult
- MapStruct (DO <-> VO)
- MyBatis Plus (BaseMapperX + LambdaQueryWrapperX)
- Spring Boot / Validation / Security (权限注解)
## 技术栈

- 服务订单(ServiceOrder): 下单、取消、金额计算
- 服务项目(ServiceItem): 可购买的服务定义
- 健康监测(HealthRecord): 指标记录+异常标记
- 档案(Profile): 基本身份与紧急联系人
## 领域拆分

或 IDE 运行类 `cn.start.pp.module.elderly.ElderlyCareApplication`。
```
mvn -pl star-module-elderly/older-module-elderly-care-biz -am spring-boot:run
```bash

## 启动

Standalone Spring Boot domain module for养老(elderly care)业务:


