package cn.start.pp.module.elderly.controller.admin.order.vo;

import cn.start.pp.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 服务订单分页查询")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyServiceOrderPageReqVO extends PageParam {

    @Schema(description = "老人档案编号")
    private Long elderlyId;

    @Schema(description = "订单状态")
    private Integer status;
}
