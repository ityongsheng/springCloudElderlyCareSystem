# Elderly Care Module API 文档

统一返回包装: `CommonResult<T>`
- 成功: `{ code: 0, data: ..., msg: "" }`
- 失败: `{ code: <错误码>, msg: <错误信息> }`

分页: `PageResult<T>` -> `{ list: [...], total: <long> }`

## 权限要求
接口上标记 `@PreAuthorize("@ss.hasPermission('<perm>')")` 的，需要对应权限字符串。例如: `elderly:profile:create`。

---
## 档案 Profile
Base Path: `/elderly/profile`

### 创建档案
POST `/elderly/profile/create`
Body: `ElderlyProfileCreateReqVO`
```json
{
  "name": "张三",
  "idCard": "110101199001010012",
  "age": 72,
  "gender": 1,
  "contactPhone": "13800000000",
  "address": "北京市朝阳区XX路",
  "emergencyContact": "李四",
  "emergencyPhone": "13900000000",
  "remark": "高血压"
}
```
Resp: `Long` (id)
Errors: 1900 (查询不存在时)

### 更新档案
PUT `/elderly/profile/update`
Body: `ElderlyProfileUpdateReqVO` (包含 `id` + 可更新字段)
Resp: `Boolean`

### 删除档案
DELETE `/elderly/profile/delete?id=123`
Resp: `Boolean`

### 分页查询
GET `/elderly/profile/page?name=张&pageNo=1&pageSize=10`
Resp: `PageResult<ElderlyProfileRespVO>`
`ElderlyProfileRespVO` 字段:
```json
{
  "id": 1,
  "name": "张三",
  "idCard": "110101199001010012",
  "age": 72,
  "gender": 1,
  "contactPhone": "13800000000",
  "address": "北京市朝阳区XX路",
  "emergencyContact": "李四",
  "emergencyPhone": "13900000000",
  "remark": "高血压",
  "createTime": "2025-11-22 14:30:00"
}
```

### 获取详情
GET `/elderly/profile/get?id=1`
Resp: `ElderlyProfileRespVO`

### 批量查询
GET `/elderly/profile/list?ids=1,2,3`
Resp: `List<ElderlyProfileRespVO>`

---
## 健康监测 HealthRecord
Base Path: `/elderly/health`

### 创建记录
POST `/elderly/health/create`
Body: `ElderlyHealthRecordCreateReqVO`
```json
{
  "elderlyId": 1,
  "type": "blood_pressure",
  "value": 130.5,
  "unit": "mmHg",
  "abnormalFlag": 0,
  "remark": "稍高"
}
```
Resp: `Long`

业务字段说明:
- type: 指标类型(如 blood_pressure, heart_rate 等)
- value/unit: 数值与单位
- abnormalFlag: 0 正常 / 1 异常

### 获取单条
GET `/elderly/health/get?id=10`
Resp: `ElderlyHealthRecordRespVO` (含 DO 同字段 + 创建时间等)

### 分页查询
GET `/elderly/health/page?elderlyId=1&type=blood_pressure&pageNo=1&pageSize=20`
Resp: `PageResult<ElderlyHealthRecordRespVO>`

---
## 服务项目 ServiceItem
Base Path: `/elderly/service-item`

### 创建项目
POST `/elderly/service-item/create`
Body: `ElderlyServiceItemCreateReqVO`
```json
{
  "name": "陪诊服务",
  "description": "专人陪同就医",
  "price": 199.00,
  "status": 1
}
```
Resp: `Long`

### 更新项目
PUT `/elderly/service-item/update`
Body: `ElderlyServiceItemUpdateReqVO` (含 id)
Resp: `Boolean`

### 删除项目
DELETE `/elderly/service-item/delete?id=5`
Resp: `Boolean`

### 分页查询
GET `/elderly/service-item/page?name=陪诊&pageNo=1&pageSize=10`
Resp: `PageResult<ElderlyServiceItemRespVO>`
`ElderlyServiceItemRespVO` 字段:
```json
{
  "id": 5,
  "name": "陪诊服务",
  "description": "专人陪同就医",
  "price": 199.00,
  "status": 1,
  "createTime": "2025-11-22 14:30:00"
}
```

### 获取单条
GET `/elderly/service-item/get?id=5`
Resp: `ElderlyServiceItemRespVO`

### 获取精简列表(下拉)
GET `/elderly/service-item/list-all-simple`
Resp: `List<ElderlyServiceItemSimpleRespVO>`
`ElderlyServiceItemSimpleRespVO` 字段:
```json
{
  "id": 5,
  "name": "陪诊服务"
}
```

---
## 服务订单 ServiceOrder
Base Path: `/elderly/service-order`

### 创建订单
POST `/elderly/service-order/create`
Body: `ElderlyServiceOrderCreateReqVO`
```json
{
  "elderlyId": 1,
  "serviceItemId": 5,
  "quantity": 2,
  "remark": "上午安排"
}
```
Resp: `Long`
计算逻辑: amount = price * quantity (后端根据 item.price 计算)

### 取消订单
POST `/elderly/service-order/cancel`
Body: `ElderlyServiceOrderCancelReqVO`
```json
{
  "id": 100,
  "cancelReason": "行程冲突"
}
```
Resp: `Boolean`
错误码: 1904 当状态不允许取消

### 获取订单
GET `/elderly/service-order/get?id=100`
Resp: `ElderlyServiceOrderRespVO`
示例:
```json
{
  "id": 100,
  "elderlyId": 1,
  "serviceItemId": 5,
  "quantity": 2,
  "price": 199.00,
  "amount": 398.00,
  "status": 1,
  "orderNo": "SO202511221430001",
  "cancelReason": null,
  "remark": "上午安排",
  "createTime": "2025-11-22 14:30:00"
}
```

### 分页查询
GET `/elderly/service-order/page?elderlyId=1&status=1&pageNo=1&pageSize=20`
Resp: `PageResult<ElderlyServiceOrderRespVO>`

---
## 数据对象字段 (DO)

### ElderlyProfileDO
| 字段 | 类型 | 说明 |
|------|------|------|
|id|Long|主键|
|name|String|姓名|
|idCard|String|身份证|
|age|Integer|年龄|
|gender|Integer|性别(约定 0/1)|
|contactPhone|String|联系电话|
|address|String|地址|
|emergencyContact|String|紧急联系人|
|emergencyPhone|String|紧急联系人电话|
|remark|String|备注|

### ElderlyHealthRecordDO
| 字段 | 类型 | 说明 |
|------|------|------|
|id|Long|主键|
|elderlyId|Long|老人档案ID|
|type|String|指标类型|
|value|BigDecimal|数值|
|unit|String|单位|
|abnormalFlag|Integer|异常标记 0正常1异常|
|remark|String|备注|

### ElderlyServiceItemDO
| 字段 | 类型 | 说明 |
|------|------|------|
|id|Long|主键|
|name|String|名称|
|description|String|描述|
|price|BigDecimal|单价|
|status|Integer|状态(启用/停用)|

### ElderlyServiceOrderDO
| 字段 | 类型 | 说明 |
|------|------|------|
|id|Long|主键|
|elderlyId|Long|老人档案ID|
|serviceItemId|Long|服务项目ID|
|quantity|Integer|数量|
|price|BigDecimal|单价快照|
|amount|BigDecimal|总金额|
|status|Integer|状态|
|orderNo|String|订单号|
|cancelReason|String|取消原因|
|remark|String|备注|

## 错误码
| Code | 描述 |
|------|------|
|1900|老人档案不存在|
|1901|健康监测记录不存在|
|1902|服务项目不存在|
|1903|服务订单不存在|
|1904|当前订单状态不允许该操作|

## 公共约定
- 数值类型 BigDecimal 以字符串返回，前端按需格式化。
- 日期时间字段来源 BaseDO: `createTime`, `updateTime`, `deleted`(逻辑删除) 等。
- 分页参数: `pageNo`, `pageSize`；返回总数 `total`。

## 测试建议
1. 先创建档案 -> 创建服务项目 -> 创建订单 -> 分页查询订单。
2. 创建健康监测记录，并分页检索同一 elderId。
3. 测试取消订单在不同 status 下的错误码 1904。

## 安全 & 权限
- 需在系统权限表中配置上述 permission 字符串，并赋予角色。

## 后续扩展建议
- 增加订单状态枚举常量与流程（已下单/进行中/完成/取消）。
- 健康监测增加告警推送逻辑（abnormalFlag=1 时触发）。
- 服务项目分类、价格阶梯。
- 档案关联照片/多媒体。

