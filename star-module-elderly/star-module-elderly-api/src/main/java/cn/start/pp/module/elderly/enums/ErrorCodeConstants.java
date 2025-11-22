package cn.start.pp.module.elderly.enums;

import cn.start.pp.framework.common.exception.ErrorCode;

/**
 * Elderly care module error codes.
 */
public interface ErrorCodeConstants {

    ErrorCode ELDERLY_PROFILE_NOT_FOUND = new ErrorCode(1900, "老人档案不存在");
    ErrorCode ELDERLY_HEALTH_RECORD_NOT_FOUND = new ErrorCode(1901, "健康监测记录不存在");
    ErrorCode ELDERLY_SERVICE_ITEM_NOT_FOUND = new ErrorCode(1902, "服务项目不存在");
    ErrorCode ELDERLY_SERVICE_ORDER_NOT_FOUND = new ErrorCode(1903, "服务订单不存在");
    ErrorCode ELDERLY_ORDER_STATUS_INVALID = new ErrorCode(1904, "当前订单状态不允许该操作");

}
