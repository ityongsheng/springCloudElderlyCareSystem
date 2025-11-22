package cn.start.pp.module.elderly.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 服务订单响应")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyServiceOrderRespVO extends ElderlyServiceOrderBaseVO {

    @Schema(description = "订单编号")
    private Long id;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "状态：0-待审批 1-已通过 2-已取消")
    private Integer status;

    @Schema(description = "单价")
    private BigDecimal price;

    @Schema(description = "总金额")
    private BigDecimal amount;

    @Schema(description = "取消原因")
    private String cancelReason;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}

