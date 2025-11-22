package cn.start.pp.module.elderly.controller.admin.profile.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ElderlyProfileBaseVO {

    @Schema(description = "老人姓名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "老人姓名不能为空")
    private String name;

    @Schema(description = "身份证号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "身份证号不能为空")
    private String idCard;

    @Schema(description = "年龄", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "年龄不能为空")
    private Integer age;

    @Schema(description = "性别：1-男 2-女", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "性别不能为空")
    private Integer gender;

    @Schema(description = "联系方式")
    private String contactPhone;

    @Schema(description = "家庭住址")
    private String address;

    @Schema(description = "紧急联系人")
    private String emergencyContact;

    @Schema(description = "紧急联系人电话")
    private String emergencyPhone;

    @Schema(description = "备注")
    private String remark;
}

