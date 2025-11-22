package cn.start.pp.module.elderly.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 服务项目新增")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyServiceItemCreateReqVO extends ElderlyServiceItemBaseVO {
}

