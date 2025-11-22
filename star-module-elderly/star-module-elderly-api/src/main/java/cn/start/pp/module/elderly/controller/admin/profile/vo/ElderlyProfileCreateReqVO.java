package cn.start.pp.module.elderly.controller.admin.profile.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 老人档案新增请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyProfileCreateReqVO extends ElderlyProfileBaseVO {
}

