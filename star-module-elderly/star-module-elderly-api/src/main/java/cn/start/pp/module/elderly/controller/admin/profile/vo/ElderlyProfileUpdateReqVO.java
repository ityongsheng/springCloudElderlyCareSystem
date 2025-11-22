package cn.start.pp.module.elderly.controller.admin.profile.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 老人档案更新请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyProfileUpdateReqVO extends ElderlyProfileBaseVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "主键不能为空")
    private Long id;
}

