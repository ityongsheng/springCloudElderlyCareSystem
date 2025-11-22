package cn.start.pp.module.elderly.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 服务订单取消请求")
@Data
public class ElderlyServiceOrderCancelReqVO {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "订单编号不能为空")
    private Long id;

    @Schema(description = "取消原因")
    private String cancelReason;
}

