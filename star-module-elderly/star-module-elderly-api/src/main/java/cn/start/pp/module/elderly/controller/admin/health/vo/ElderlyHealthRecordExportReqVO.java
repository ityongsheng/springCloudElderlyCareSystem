package cn.start.pp.module.elderly.controller.admin.health.vo;

import cn.start.pp.framework.common.pojo.PageParam; // 正确分页基类
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康监测导出请求")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyHealthRecordExportReqVO extends PageParam {
    @Schema(description = "老人档案ID")
    private Long elderlyId;
    @Schema(description = "指标类型")
    private String type;
}
