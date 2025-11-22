package cn.start.pp.module.elderly.controller.admin.health.vo;

import cn.start.pp.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康监测分页查询")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyHealthRecordPageReqVO extends PageParam {

    @Schema(description = "老人档案编号")
    private Long elderlyId;

    @Schema(description = "监测类型")
    private String type;
}
