package cn.start.pp.module.elderly.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ElderlyServiceOrderBaseVO {

    @Schema(description = "老人档案编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "老人档案编号不能为空")
    private Long elderlyId;

    @Schema(description = "服务项目编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "服务项目编号不能为空")
    private Long serviceItemId;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "数量不能为空")
    @Min(value = 1, message = "数量必须大于 0")
    private Integer quantity;

    @Schema(description = "备注")
    private String remark;
}

