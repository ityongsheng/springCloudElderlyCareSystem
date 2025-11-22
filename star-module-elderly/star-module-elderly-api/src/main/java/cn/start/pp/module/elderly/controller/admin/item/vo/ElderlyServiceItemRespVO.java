package cn.start.pp.module.elderly.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 服务项目响应")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyServiceItemRespVO extends ElderlyServiceItemBaseVO {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}

