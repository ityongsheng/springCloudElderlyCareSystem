package cn.start.pp.module.elderly.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 服务订单创建请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyServiceOrderCreateReqVO extends ElderlyServiceOrderBaseVO {
}

