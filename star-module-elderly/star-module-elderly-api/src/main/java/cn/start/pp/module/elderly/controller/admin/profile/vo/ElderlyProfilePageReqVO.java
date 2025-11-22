package cn.start.pp.module.elderly.controller.admin.profile.vo;

import cn.start.pp.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 老人档案分页查询请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyProfilePageReqVO extends PageParam {

    @Schema(description = "老人姓名")
    private String name;

    @Schema(description = "身份证号")
    private String idCard;

}
