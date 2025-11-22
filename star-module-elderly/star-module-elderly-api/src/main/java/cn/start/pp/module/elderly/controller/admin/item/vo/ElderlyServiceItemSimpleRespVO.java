package cn.start.pp.module.elderly.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 服务项目精简响应")
@Data
public class ElderlyServiceItemSimpleRespVO {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "服务名称")
    private String name;
}

