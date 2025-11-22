package cn.start.pp.module.elderly.controller.admin.profile.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 老人档案响应")
@Data
public class ElderlyProfileRespVO {

    @Schema(description = "主键", example = "1024")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "身份证")
    private String idCard;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "性别")
    private Integer gender;

    @Schema(description = "联系电话")
    private String contactPhone;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "紧急联系人")
    private String emergencyContact;

    @Schema(description = "紧急联系人电话")
    private String emergencyPhone;

    @Schema(description = "备注")
    private String remark;
}
