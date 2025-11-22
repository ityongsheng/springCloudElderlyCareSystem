package cn.start.pp.module.elderly.controller.admin.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ElderlyServiceItemBaseVO {

    @Schema(description = "服务名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "服务名称不能为空")
    private String name;

    @Schema(description = "服务描述")
    private String description;

    @Schema(description = "单价", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "单价不能为空")
    private BigDecimal price;

    @Schema(description = "启用状态 0-禁用 1-启用", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "状态不能为空")
    private Integer status;
}

