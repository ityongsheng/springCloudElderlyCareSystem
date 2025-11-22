# 养老服务模块 TypeScript 接口文档

## 📋 目录

- [概述](#概述)
- [快速开始](#快速开始)
- [类型定义](#类型定义)
- [API 接口](#api-接口)
- [使用示例](#使用示例)
- [字段说明](#字段说明)

## 概述

本文档提供养老服务模块的完整 TypeScript 接口定义，包括：

- **老人档案管理** - 老人基本信息的增删改查
- **服务项目管理** - 养老服务项目的管理
- **服务订单管理** - 服务订单的创建、查询和取消
- **健康监测管理** - 老人健康数据的记录和查询

**基础 URL**: `http://localhost:8095/admin-api`

## 快速开始

### 1. 导入类型定义

```typescript
import {
  CommonResult,
  PageResult,
  ElderlyProfileResp,
  ElderlyServiceItemResp,
  ElderlyServiceOrderResp,
  ElderlyHealthRecordResp,
  // ... 其他需要的类型
} from './elderly-service.types';
```

### 2. 配置 Axios 实例

```typescript
import axios from 'axios';
import { API_BASE_URL } from './elderly-service.types';

const request = axios.create({
  baseURL: API_BASE_URL,
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// 请求拦截器 - 添加 Token
request.interceptors.request.use((config) => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// 响应拦截器 - 统一处理响应
request.interceptors.response.use(
  (response) => response.data,
  (error) => {
    console.error('API Error:', error);
    return Promise.reject(error);
  }
);
```

## 类型定义

### 通用类型

#### CommonResult\<T\>
```typescript
interface CommonResult<T = any> {
  code: number;      // 0-成功，其他-失败
  msg: string;       // 响应消息
  data: T;          // 响应数据
}
```

#### PageResult\<T\>
```typescript
interface PageResult<T = any> {
  list: T[];        // 数据列表
  total: number;    // 总记录数
}
```

#### PageParam
```typescript
interface PageParam {
  pageNo?: number;    // 页码，从 1 开始
  pageSize?: number;  // 每页条数，默认 10
}
```

### 老人档案类型

#### ElderlyProfileBase
```typescript
interface ElderlyProfileBase {
  name: string;                // 老人姓名（必填）
  idCard: string;              // 身份证号（必填）
  age: number;                 // 年龄（必填）
  gender: 1 | 2;               // 性别：1-男 2-女（必填）
  contactPhone?: string;       // 联系方式
  address?: string;            // 家庭住址
  emergencyContact?: string;   // 紧急联系人
  emergencyPhone?: string;     // 紧急联系人电话
  remark?: string;             // 备注
}
```

#### ElderlyProfileResp
```typescript
interface ElderlyProfileResp {
  id: number;                  // 主键 ID
  createTime: string;          // 创建时间
  name: string;                // 姓名
  idCard: string;              // 身份证
  age: number;                 // 年龄
  gender: 1 | 2;               // 性别
  contactPhone?: string;       // 联系电话
  address?: string;            // 地址
  emergencyContact?: string;   // 紧急联系人
  emergencyPhone?: string;     // 紧急联系人电话
  remark?: string;             // 备注
}
```

### 服务项目类型

#### ElderlyServiceItemBase
```typescript
interface ElderlyServiceItemBase {
  name: string;                // 服务名称（必填）
  description?: string;        // 服务描述
  price: number;               // 单价（元）（必填）
  status: 0 | 1;               // 启用状态：0-禁用 1-启用（必填）
}
```

#### ElderlyServiceItemResp
```typescript
interface ElderlyServiceItemResp extends ElderlyServiceItemBase {
  id: number;                  // 主键 ID
  createTime: string;          // 创建时间
}
```

#### ElderlyServiceItemSimpleResp
```typescript
interface ElderlyServiceItemSimpleResp {
  id: number;                  // 主键 ID
  name: string;                // 服务名称
}
```

### 服务订单类型

#### ElderlyServiceOrderBase
```typescript
interface ElderlyServiceOrderBase {
  elderlyId: number;           // 老人档案编号（必填）
  serviceItemId: number;       // 服务项目编号（必填）
  quantity: number;            // 数量（必填，必须大于 0）
  remark?: string;             // 备注
}
```

#### ElderlyServiceOrderResp
```typescript
interface ElderlyServiceOrderResp extends ElderlyServiceOrderBase {
  id: number;                  // 订单编号
  orderNo: string;             // 订单号
  status: 0 | 1 | 2;           // 状态：0-待审批 1-已通过 2-已取消
  price: number;               // 单价（元）
  amount: number;              // 总金额（元）
  cancelReason?: string;       // 取消原因
  createTime: string;          // 创建时间
}
```

### 健康监测类型

#### ElderlyHealthRecordBase
```typescript
interface ElderlyHealthRecordBase {
  elderlyId: number;           // 老人档案编号（必填）
  type: string;                // 监测类型（必填，如：血压、血糖、心率等）
  value: number;               // 监测值（必填）
  unit?: string;               // 单位（如：mmHg、mg/dL、次/分等）
  remark?: string;             // 备注
}
```

#### ElderlyHealthRecordResp
```typescript
interface ElderlyHealthRecordResp extends ElderlyHealthRecordBase {
  id: number;                  // 主键 ID
  abnormalFlag: 0 | 1;         // 是否异常：0-正常 1-异常
  createTime: string;          // 创建时间
}
```

## API 接口

### 老人档案 API

| 方法 | 路径 | 说明 | 权限 |
|------|------|------|------|
| POST | `/elderly/profile/create` | 创建老人档案 | `elderly:profile:create` |
| PUT | `/elderly/profile/update` | 更新老人档案 | `elderly:profile:update` |
| DELETE | `/elderly/profile/delete` | 删除老人档案 | `elderly:profile:delete` |
| GET | `/elderly/profile/get` | 获取老人档案详情 | `elderly:profile:query` |
| GET | `/elderly/profile/page` | 分页查询老人档案 | `elderly:profile:query` |
| GET | `/elderly/profile/list` | 批量查询老人档案 | `elderly:profile:query` |

### 服务项目 API

| 方法 | 路径 | 说明 | 权限 |
|------|------|------|------|
| POST | `/elderly/service-item/create` | 创建服务项目 | `elderly:item:create` |
| PUT | `/elderly/service-item/update` | 更新服务项目 | `elderly:item:update` |
| DELETE | `/elderly/service-item/delete` | 删除服务项目 | `elderly:item:delete` |
| GET | `/elderly/service-item/get` | 获取服务项目详情 | `elderly:item:query` |
| GET | `/elderly/service-item/page` | 分页查询服务项目 | `elderly:item:query` |
| GET | `/elderly/service-item/list-all-simple` | 获取精简服务项目列表 | 无需权限 |

### 服务订单 API

| 方法 | 路径 | 说明 | 权限 |
|------|------|------|------|
| POST | `/elderly/service-order/create` | 创建服务订单 | `elderly:order:create` |
| POST | `/elderly/service-order/cancel` | 取消服务订单 | `elderly:order:cancel` |
| GET | `/elderly/service-order/get` | 获取服务订单详情 | `elderly:order:query` |
| GET | `/elderly/service-order/page` | 分页查询服务订单 | `elderly:order:query` |

### 健康监测 API

| 方法 | 路径 | 说明 | 权限 |
|------|------|------|------|
| POST | `/elderly/health/create` | 创建健康监测记录 | `elderly:health:create` |
| GET | `/elderly/health/get` | 获取健康监测记录详情 | `elderly:health:query` |
| GET | `/elderly/health/page` | 分页查询健康监测记录 | `elderly:health:query` |

## 使用示例

### 1. 老人档案管理

#### 创建老人档案
```typescript
import { ElderlyProfileCreateReq, CommonResult } from './elderly-service.types';

async function createProfile() {
  const data: ElderlyProfileCreateReq = {
    name: '张三',
    idCard: '110101195001011234',
    age: 74,
    gender: 1,
    contactPhone: '13800138000',
    address: '北京市朝阳区XX街道XX号',
    emergencyContact: '李四',
    emergencyPhone: '13900139000',
    remark: '有高血压病史',
  };

  const result: CommonResult<number> = await request.post('/elderly/profile/create', data);
  
  if (result.code === 0) {
    console.log('创建成功，ID:', result.data);
  }
}
```

#### 分页查询老人档案
```typescript
import { ElderlyProfilePageReq, CommonResult, PageResult, ElderlyProfileResp } from './elderly-service.types';

async function getProfilePage() {
  const params: ElderlyProfilePageReq = {
    pageNo: 1,
    pageSize: 10,
    name: '张',  // 模糊查询
  };

  const result: CommonResult<PageResult<ElderlyProfileResp>> = await request.get('/elderly/profile/page', { params });
  
  if (result.code === 0) {
    console.log('总数:', result.data.total);
    console.log('列表:', result.data.list);
  }
}
```

#### 更新老人档案
```typescript
import { ElderlyProfileUpdateReq, CommonResult } from './elderly-service.types';

async function updateProfile() {
  const data: ElderlyProfileUpdateReq = {
    id: 1,
    name: '张三',
    idCard: '110101195001011234',
    age: 75,  // 更新年龄
    gender: 1,
    contactPhone: '13800138001',  // 更新电话
  };

  const result: CommonResult<boolean> = await request.put('/elderly/profile/update', data);
  
  if (result.code === 0) {
    console.log('更新成功');
  }
}
```

### 2. 服务项目管理

#### 获取精简服务项目列表（用于下拉选择）
```typescript
import { CommonResult, ElderlyServiceItemSimpleResp } from './elderly-service.types';

async function getSimpleServiceItems() {
  const result: CommonResult<ElderlyServiceItemSimpleResp[]> = await request.get('/elderly/service-item/list-all-simple');
  
  if (result.code === 0) {
    const options = result.data.map(item => ({
      label: item.name,
      value: item.id,
    }));
    console.log('服务项目选项:', options);
  }
}
```

#### 创建服务项目
```typescript
import { ElderlyServiceItemCreateReq, CommonResult } from './elderly-service.types';

async function createServiceItem() {
  const data: ElderlyServiceItemCreateReq = {
    name: '日常护理',
    description: '包括洗漱、喂饭、翻身等基础护理服务',
    price: 100.00,
    status: 1,  // 启用
  };

  const result: CommonResult<number> = await request.post('/elderly/service-item/create', data);
  
  if (result.code === 0) {
    console.log('创建成功，ID:', result.data);
  }
}
```

### 3. 服务订单管理

#### 创建服务订单
```typescript
import { ElderlyServiceOrderCreateReq, CommonResult } from './elderly-service.types';

async function createOrder() {
  const data: ElderlyServiceOrderCreateReq = {
    elderlyId: 1,           // 老人档案 ID
    serviceItemId: 1,       // 服务项目 ID
    quantity: 30,           // 数量（如：30天）
    remark: '每日上午 9:00-11:00',
  };

  const result: CommonResult<number> = await request.post('/elderly/service-order/create', data);
  
  if (result.code === 0) {
    console.log('订单创建成功，ID:', result.data);
  }
}
```

#### 分页查询服务订单
```typescript
import { ElderlyServiceOrderPageReq, CommonResult, PageResult, ElderlyServiceOrderResp } from './elderly-service.types';

async function getOrderPage() {
  const params: ElderlyServiceOrderPageReq = {
    pageNo: 1,
    pageSize: 10,
    elderlyId: 1,     // 查询指定老人的订单
    status: 0,        // 只查询待审批的订单
  };

  const result: CommonResult<PageResult<ElderlyServiceOrderResp>> = await request.get('/elderly/service-order/page', { params });
  
  if (result.code === 0) {
    result.data.list.forEach(order => {
      console.log(`订单号: ${order.orderNo}, 金额: ${order.amount}元, 状态: ${order.status}`);
    });
  }
}
```

#### 取消服务订单
```typescript
import { ElderlyServiceOrderCancelReq, CommonResult } from './elderly-service.types';

async function cancelOrder() {
  const data: ElderlyServiceOrderCancelReq = {
    id: 1,
    cancelReason: '老人身体不适，暂停服务',
  };

  const result: CommonResult<boolean> = await request.post('/elderly/service-order/cancel', data);
  
  if (result.code === 0) {
    console.log('订单取消成功');
  }
}
```

### 4. 健康监测管理

#### 创建健康监测记录
```typescript
import { ElderlyHealthRecordCreateReq, CommonResult } from './elderly-service.types';

async function createHealthRecord() {
  const data: ElderlyHealthRecordCreateReq = {
    elderlyId: 1,
    type: '血压',
    value: 140,
    unit: 'mmHg',
    remark: '高压 140，低压 90',
  };

  const result: CommonResult<number> = await request.post('/elderly/health/create', data);
  
  if (result.code === 0) {
    console.log('健康记录创建成功，ID:', result.data);
  }
}
```

#### 分页查询健康监测记录
```typescript
import { ElderlyHealthRecordPageReq, CommonResult, PageResult, ElderlyHealthRecordResp } from './elderly-service.types';

async function getHealthRecordPage() {
  const params: ElderlyHealthRecordPageReq = {
    pageNo: 1,
    pageSize: 10,
    elderlyId: 1,
    type: '血压',
    abnormalFlag: 1,  // 只查询异常记录
  };

  const result: CommonResult<PageResult<ElderlyHealthRecordResp>> = await request.get('/elderly/health/page', { params });
  
  if (result.code === 0) {
    result.data.list.forEach(record => {
      console.log(`${record.type}: ${record.value}${record.unit}, 异常: ${record.abnormalFlag === 1 ? '是' : '否'}`);
    });
  }
}
```

## 字段说明

### 性别 (gender)
- `1` - 男
- `2` - 女

### 服务项目状态 (status)
- `0` - 禁用
- `1` - 启用

### 服务订单状态 (status)
- `0` - 待审批
- `1` - 已通过
- `2` - 已取消

### 健康监测异常标志 (abnormalFlag)
- `0` - 正常
- `1` - 异常

### 常见监测类型 (type)
- `血压` - 单位：mmHg
- `血糖` - 单位：mg/dL 或 mmol/L
- `心率` - 单位：次/分
- `体温` - 单位：℃
- `血氧` - 单位：%

## 注意事项

1. **认证**: 除了 `/elderly/service-item/list-all-simple` 接口外，其他接口都需要登录认证
2. **权限**: 每个接口都有对应的权限要求，请确保用户有相应权限
3. **数据验证**: 
   - 必填字段不能为空
   - 数值类型字段要符合范围要求（如：数量必须大于 0）
   - 身份证号需要符合格式要求
4. **时间格式**: 所有时间字段使用 ISO 8601 格式（如：`2025-11-22T17:44:25+08:00`）
5. **金额精度**: 金额字段使用 `number` 类型，建议保留两位小数

## 错误处理

```typescript
try {
  const result = await request.post('/elderly/profile/create', data);
  if (result.code === 0) {
    // 成功处理
  } else {
    // 业务错误处理
    console.error('业务错误:', result.msg);
  }
} catch (error) {
  // 网络错误或其他异常
  console.error('请求失败:', error);
}
```

## 相关文档

- [API 测试报告](./API-TEST-REPORT.md)
- [Swagger 文档](http://localhost:8095/doc.html)
- [接口测试脚本](./test-api.sh)

---

**版本**: 1.0.0  
**最后更新**: 2025-11-22  
**维护者**: 开发团队
