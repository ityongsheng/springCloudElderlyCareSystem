package cn.start.pp.module.elderly.controller.admin.health.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 健康监测记录响应")
@Data
@EqualsAndHashCode(callSuper = true)
public class ElderlyHealthRecordRespVO extends ElderlyHealthRecordBaseVO {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "是否异常：0-正常 1-异常")
    private Integer abnormalFlag;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}

