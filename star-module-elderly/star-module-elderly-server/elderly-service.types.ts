/**
 * 养老服务模块 TypeScript 接口定义
 * 
 * @module elderly-service
 * @description 包含老人档案、服务项目、服务订单、健康监测等模块的接口定义
 * @version 1.0.0
 * @baseURL http://localhost:8095/admin-api
 */

// ==================== 通用类型定义 ====================

/**
 * 通用响应结构
 */
export interface CommonResult<T = any> {
  /** 响应码：0-成功，其他-失败 */
  code: number;
  /** 响应消息 */
  msg: string;
  /** 响应数据 */
  data: T;
}

/**
 * 分页响应结构
 */
export interface PageResult<T = any> {
  /** 数据列表 */
  list: T[];
  /** 总记录数 */
  total: number;
}

/**
 * 分页请求参数
 */
export interface PageParam {
  /** 页码，从 1 开始 */
  pageNo?: number;
  /** 每页条数，默认 10 */
  pageSize?: number;
}

// ==================== 老人档案模块 ====================

/**
 * 老人档案 - 基础信息
 */
export interface ElderlyProfileBase {
  /** 老人姓名 */
  name: string;
  /** 身份证号 */
  idCard: string;
  /** 年龄 */
  age: number;
  /** 性别：1-男 2-女 */
  gender: 1 | 2;
  /** 联系方式 */
  contactPhone?: string;
  /** 家庭住址 */
  address?: string;
  /** 紧急联系人 */
  emergencyContact?: string;
  /** 紧急联系人电话 */
  emergencyPhone?: string;
  /** 备注 */
  remark?: string;
}

/**
 * 老人档案 - 创建请求
 */
export interface ElderlyProfileCreateReq extends ElderlyProfileBase {}

/**
 * 老人档案 - 更新请求
 */
export interface ElderlyProfileUpdateReq extends ElderlyProfileBase {
  /** 主键 ID */
  id: number;
}

/**
 * 老人档案 - 响应
 */
export interface ElderlyProfileResp {
  /** 主键 ID */
  id: number;
  /** 创建时间 */
  createTime: string;
  /** 姓名 */
  name: string;
  /** 身份证 */
  idCard: string;
  /** 年龄 */
  age: number;
  /** 性别：1-男 2-女 */
  gender: 1 | 2;
  /** 联系电话 */
  contactPhone?: string;
  /** 地址 */
  address?: string;
  /** 紧急联系人 */
  emergencyContact?: string;
  /** 紧急联系人电话 */
  emergencyPhone?: string;
  /** 备注 */
  remark?: string;
}

/**
 * 老人档案 - 分页查询请求
 */
export interface ElderlyProfilePageReq extends PageParam {
  /** 老人姓名（模糊查询） */
  name?: string;
  /** 身份证号（模糊查询） */
  idCard?: string;
}

// ==================== 服务项目模块 ====================

/**
 * 服务项目 - 基础信息
 */
export interface ElderlyServiceItemBase {
  /** 服务名称 */
  name: string;
  /** 服务描述 */
  description?: string;
  /** 单价（元） */
  price: number;
  /** 启用状态：0-禁用 1-启用 */
  status: 0 | 1;
}

/**
 * 服务项目 - 创建请求
 */
export interface ElderlyServiceItemCreateReq extends ElderlyServiceItemBase {}

/**
 * 服务项目 - 更新请求
 */
export interface ElderlyServiceItemUpdateReq extends ElderlyServiceItemBase {
  /** 主键 ID */
  id: number;
}

/**
 * 服务项目 - 响应
 */
export interface ElderlyServiceItemResp extends ElderlyServiceItemBase {
  /** 主键 ID */
  id: number;
  /** 创建时间 */
  createTime: string;
}

/**
 * 服务项目 - 精简响应（用于下拉选择）
 */
export interface ElderlyServiceItemSimpleResp {
  /** 主键 ID */
  id: number;
  /** 服务名称 */
  name: string;
}

/**
 * 服务项目 - 分页查询请求
 */
export interface ElderlyServiceItemPageReq extends PageParam {
  /** 服务名称（模糊查询） */
  name?: string;
  /** 状态：0-禁用 1-启用 */
  status?: 0 | 1;
}

// ==================== 服务订单模块 ====================

/**
 * 服务订单 - 基础信息
 */
export interface ElderlyServiceOrderBase {
  /** 老人档案编号 */
  elderlyId: number;
  /** 服务项目编号 */
  serviceItemId: number;
  /** 数量（必须大于 0） */
  quantity: number;
  /** 备注 */
  remark?: string;
}

/**
 * 服务订单 - 创建请求
 */
export interface ElderlyServiceOrderCreateReq extends ElderlyServiceOrderBase {}

/**
 * 服务订单 - 响应
 */
export interface ElderlyServiceOrderResp extends ElderlyServiceOrderBase {
  /** 订单编号 */
  id: number;
  /** 订单号 */
  orderNo: string;
  /** 状态：0-待审批 1-已通过 2-已取消 */
  status: 0 | 1 | 2;
  /** 单价（元） */
  price: number;
  /** 总金额（元） */
  amount: number;
  /** 取消原因 */
  cancelReason?: string;
  /** 创建时间 */
  createTime: string;
}

/**
 * 服务订单 - 取消请求
 */
export interface ElderlyServiceOrderCancelReq {
  /** 订单编号 */
  id: number;
  /** 取消原因 */
  cancelReason?: string;
}

/**
 * 服务订单 - 分页查询请求
 */
export interface ElderlyServiceOrderPageReq extends PageParam {
  /** 老人档案编号 */
  elderlyId?: number;
  /** 服务项目编号 */
  serviceItemId?: number;
  /** 状态：0-待审批 1-已通过 2-已取消 */
  status?: 0 | 1 | 2;
  /** 订单号 */
  orderNo?: string;
}

// ==================== 健康监测模块 ====================

/**
 * 健康监测记录 - 基础信息
 */
export interface ElderlyHealthRecordBase {
  /** 老人档案编号 */
  elderlyId: number;
  /** 监测类型（如：血压、血糖、心率等） */
  type: string;
  /** 监测值 */
  value: number;
  /** 单位（如：mmHg、mg/dL、次/分等） */
  unit?: string;
  /** 备注 */
  remark?: string;
}

/**
 * 健康监测记录 - 创建请求
 */
export interface ElderlyHealthRecordCreateReq extends ElderlyHealthRecordBase {}

/**
 * 健康监测记录 - 响应
 */
export interface ElderlyHealthRecordResp extends ElderlyHealthRecordBase {
  /** 主键 ID */
  id: number;
  /** 是否异常：0-正常 1-异常 */
  abnormalFlag: 0 | 1;
  /** 创建时间 */
  createTime: string;
}

/**
 * 健康监测记录 - 分页查询请求
 */
export interface ElderlyHealthRecordPageReq extends PageParam {
  /** 老人档案编号 */
  elderlyId?: number;
  /** 监测类型 */
  type?: string;
  /** 是否异常：0-正常 1-异常 */
  abnormalFlag?: 0 | 1;
}

// ==================== API 接口定义 ====================

/**
 * 老人档案 API
 */
export interface ElderlyProfileAPI {
  /**
   * 创建老人档案
   * @method POST
   * @url /admin-api/elderly/profile/create
   * @permission elderly:profile:create
   */
  create(data: ElderlyProfileCreateReq): Promise<CommonResult<number>>;

  /**
   * 更新老人档案
   * @method PUT
   * @url /admin-api/elderly/profile/update
   * @permission elderly:profile:update
   */
  update(data: ElderlyProfileUpdateReq): Promise<CommonResult<boolean>>;

  /**
   * 删除老人档案
   * @method DELETE
   * @url /admin-api/elderly/profile/delete
   * @permission elderly:profile:delete
   */
  delete(id: number): Promise<CommonResult<boolean>>;

  /**
   * 获取老人档案详情
   * @method GET
   * @url /admin-api/elderly/profile/get
   * @permission elderly:profile:query
   */
  get(id: number): Promise<CommonResult<ElderlyProfileResp>>;

  /**
   * 分页查询老人档案
   * @method GET
   * @url /admin-api/elderly/profile/page
   * @permission elderly:profile:query
   */
  page(params: ElderlyProfilePageReq): Promise<CommonResult<PageResult<ElderlyProfileResp>>>;

  /**
   * 批量查询老人档案
   * @method GET
   * @url /admin-api/elderly/profile/list
   * @permission elderly:profile:query
   */
  list(ids: number[]): Promise<CommonResult<ElderlyProfileResp[]>>;
}

/**
 * 服务项目 API
 */
export interface ElderlyServiceItemAPI {
  /**
   * 创建服务项目
   * @method POST
   * @url /admin-api/elderly/service-item/create
   * @permission elderly:item:create
   */
  create(data: ElderlyServiceItemCreateReq): Promise<CommonResult<number>>;

  /**
   * 更新服务项目
   * @method PUT
   * @url /admin-api/elderly/service-item/update
   * @permission elderly:item:update
   */
  update(data: ElderlyServiceItemUpdateReq): Promise<CommonResult<boolean>>;

  /**
   * 删除服务项目
   * @method DELETE
   * @url /admin-api/elderly/service-item/delete
   * @permission elderly:item:delete
   */
  delete(id: number): Promise<CommonResult<boolean>>;

  /**
   * 获取服务项目详情
   * @method GET
   * @url /admin-api/elderly/service-item/get
   * @permission elderly:item:query
   */
  get(id: number): Promise<CommonResult<ElderlyServiceItemResp>>;

  /**
   * 分页查询服务项目
   * @method GET
   * @url /admin-api/elderly/service-item/page
   * @permission elderly:item:query
   */
  page(params: ElderlyServiceItemPageReq): Promise<CommonResult<PageResult<ElderlyServiceItemResp>>>;

  /**
   * 获取精简服务项目列表（用于下拉选择）
   * @method GET
   * @url /admin-api/elderly/service-item/list-all-simple
   * @permission 无需权限
   */
  listAllSimple(): Promise<CommonResult<ElderlyServiceItemSimpleResp[]>>;
}

/**
 * 服务订单 API
 */
export interface ElderlyServiceOrderAPI {
  /**
   * 创建服务订单
   * @method POST
   * @url /admin-api/elderly/service-order/create
   * @permission elderly:order:create
   */
  create(data: ElderlyServiceOrderCreateReq): Promise<CommonResult<number>>;

  /**
   * 取消服务订单
   * @method POST
   * @url /admin-api/elderly/service-order/cancel
   * @permission elderly:order:cancel
   */
  cancel(data: ElderlyServiceOrderCancelReq): Promise<CommonResult<boolean>>;

  /**
   * 获取服务订单详情
   * @method GET
   * @url /admin-api/elderly/service-order/get
   * @permission elderly:order:query
   */
  get(id: number): Promise<CommonResult<ElderlyServiceOrderResp>>;

  /**
   * 分页查询服务订单
   * @method GET
   * @url /admin-api/elderly/service-order/page
   * @permission elderly:order:query
   */
  page(params: ElderlyServiceOrderPageReq): Promise<CommonResult<PageResult<ElderlyServiceOrderResp>>>;
}

/**
 * 健康监测 API
 */
export interface ElderlyHealthRecordAPI {
  /**
   * 创建健康监测记录
   * @method POST
   * @url /admin-api/elderly/health/create
   * @permission elderly:health:create
   */
  create(data: ElderlyHealthRecordCreateReq): Promise<CommonResult<number>>;

  /**
   * 获取健康监测记录详情
   * @method GET
   * @url /admin-api/elderly/health/get
   * @permission elderly:health:query
   */
  get(id: number): Promise<CommonResult<ElderlyHealthRecordResp>>;

  /**
   * 分页查询健康监测记录
   * @method GET
   * @url /admin-api/elderly/health/page
   * @permission elderly:health:query
   */
  page(params: ElderlyHealthRecordPageReq): Promise<CommonResult<PageResult<ElderlyHealthRecordResp>>>;
}

// ==================== 枚举定义 ====================

/**
 * 性别枚举
 */
export enum GenderEnum {
  /** 男 */
  MALE = 1,
  /** 女 */
  FEMALE = 2,
}

/**
 * 服务项目状态枚举
 */
export enum ServiceItemStatusEnum {
  /** 禁用 */
  DISABLED = 0,
  /** 启用 */
  ENABLED = 1,
}

/**
 * 服务订单状态枚举
 */
export enum ServiceOrderStatusEnum {
  /** 待审批 */
  PENDING = 0,
  /** 已通过 */
  APPROVED = 1,
  /** 已取消 */
  CANCELLED = 2,
}

/**
 * 健康监测异常标志枚举
 */
export enum HealthAbnormalFlagEnum {
  /** 正常 */
  NORMAL = 0,
  /** 异常 */
  ABNORMAL = 1,
}

// ==================== 常量定义 ====================

/**
 * API 基础路径
 */
export const API_BASE_URL = 'http://localhost:8095/admin-api';

/**
 * 模块路径
 */
export const API_PATHS = {
  /** 老人档案 */
  PROFILE: '/elderly/profile',
  /** 服务项目 */
  SERVICE_ITEM: '/elderly/service-item',
  /** 服务订单 */
  SERVICE_ORDER: '/elderly/service-order',
  /** 健康监测 */
  HEALTH: '/elderly/health',
} as const;

/**
 * 权限标识
 */
export const PERMISSIONS = {
  PROFILE: {
    CREATE: 'elderly:profile:create',
    UPDATE: 'elderly:profile:update',
    DELETE: 'elderly:profile:delete',
    QUERY: 'elderly:profile:query',
  },
  ITEM: {
    CREATE: 'elderly:item:create',
    UPDATE: 'elderly:item:update',
    DELETE: 'elderly:item:delete',
    QUERY: 'elderly:item:query',
  },
  ORDER: {
    CREATE: 'elderly:order:create',
    CANCEL: 'elderly:order:cancel',
    QUERY: 'elderly:order:query',
  },
  HEALTH: {
    CREATE: 'elderly:health:create',
    QUERY: 'elderly:health:query',
  },
} as const;
