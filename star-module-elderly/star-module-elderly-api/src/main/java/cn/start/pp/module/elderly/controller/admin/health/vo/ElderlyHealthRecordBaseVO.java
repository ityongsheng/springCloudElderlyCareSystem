package cn.start.pp.module.elderly.controller.admin.health.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ElderlyHealthRecordBaseVO {

    @Schema(description = "老人档案编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "老人档案编号不能为空")
    private Long elderlyId;

    @Schema(description = "监测类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "监测类型不能为空")
    private String type;

    @Schema(description = "监测值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "监测值不能为空")
    private BigDecimal value;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "备注")
    private String remark;
}
